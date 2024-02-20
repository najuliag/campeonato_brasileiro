package com.example.campeonato_brasileiro.services;

import com.example.campeonato_brasileiro.dto.CartoesDTO;
import com.example.campeonato_brasileiro.exceptions.ResourceNotFound;
import com.example.campeonato_brasileiro.model.Partida;
import com.example.campeonato_brasileiro.repositories.PartidaRepository;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;

    @Transactional
    public void create(String caminhoDoArquivo) throws IOException {
        try (CSVReader reader = new CSVReader(new FileReader(caminhoDoArquivo))) {
            String[] headers = reader.readNext();

            if (headers != null) {
                String[] linha;
                List<Partida> modelos = new ArrayList<>();

                while ((linha = reader.readNext()) != null) {
                    Partida partida = new Partida();
                    partida.setRodada(linha[1]);
                    partida.setData(linha[2]);
                        partida.setHora(linha[3]);
                        partida.setMandante(linha[4]);
                        partida.setVisitante(linha[5]);
                        partida.setFormacao_mandante(linha[6]);
                        partida.setFormacao_visitante(linha[7]);
                        partida.setTecnico_mandante(linha[8]);
                        partida.setTecnico_visitante(linha[9]);
                        partida.setVencedor(linha[10]);
                        partida.setArena(linha[11]);
                        partida.setMandante_Placar(linha[12]);
                        partida.setVisitante_Placar(linha[13]);
                        partida.setMandante_Estado(linha[14]);
                        partida.setVisitante_Estado(linha[15]);

                        modelos.add(partida);
                    }

                partidaRepository.saveAll(modelos);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ResponseEntity<List<Partida>> findAll(){
        try {
            List<Partida> partidas = partidaRepository.findAll();
            return new ResponseEntity<>(partidas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Partida findById(Long id) {
        return partidaRepository.findById(id).orElseThrow(() -> new ResourceNotFound("No records found for this id."));
    }

    public CartoesDTO clubeComMaisCartoesAmarelos() {
        return partidaRepository.clubeComMaisCartoesAmarelos()
                .stream()
                .max(Comparator.comparingLong(CartoesDTO::getQntdCartoes))
                .orElse(null);
    }
}
