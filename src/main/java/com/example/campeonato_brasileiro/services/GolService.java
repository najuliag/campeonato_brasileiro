package com.example.campeonato_brasileiro.services;

import com.example.campeonato_brasileiro.exceptions.ResourceNotFound;
import com.example.campeonato_brasileiro.model.Gol;
import com.example.campeonato_brasileiro.model.Partida;
import com.example.campeonato_brasileiro.repositories.GolRepository;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class GolService {
    @Autowired
    private GolRepository golRepository;
    @Autowired
    private PartidaService partidaService;

    @Transactional
    public void create(String caminhoDoArquivo) throws IOException {
        try (CSVReader reader = new CSVReader(new FileReader(caminhoDoArquivo))) {

            String[] headers = reader.readNext();

            if (headers != null) {
                String[] linha;
                List<Gol> gols = new ArrayList<>();
                while ((linha = reader.readNext()) != null) {
                    Long partidaId = Long.valueOf(linha[0]);
                    Partida partida = partidaService.findById(partidaId);

                    Gol gol = new Gol();
                    gol.setPartida(partida);
                    gol.setRodada(linha[1]);
                    gol.setClube(linha[2]);
                    gol.setAtleta(linha[3]);
                    gol.setMinuto(linha[4]);
                    gol.setTipo_de_gol(linha[5]);

                    gols.add(gol);
                }
                List<Gol> golsSalvos = golRepository.saveAll(gols);
                for (Gol gol : golsSalvos) {
                    gol.getPartida().getId();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResponseEntity<List<Gol>> findAll(){
        try {
            List<Gol> gols = golRepository.findAll();
            return new ResponseEntity<>(gols, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public Gol findById(Long id) {
        return golRepository.findById(id).orElseThrow(() -> new ResourceNotFound("No records found for this id."));
    }
}
