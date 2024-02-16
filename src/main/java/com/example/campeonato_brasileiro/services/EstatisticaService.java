package com.example.campeonato_brasileiro.services;

import com.example.campeonato_brasileiro.exceptions.ResourceNotFound;
import com.example.campeonato_brasileiro.model.Estatistica;
import com.example.campeonato_brasileiro.model.Gol;
import com.example.campeonato_brasileiro.model.Partida;
import com.example.campeonato_brasileiro.repositories.EstatisticaRepository;
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

@Service
public class EstatisticaService {

    @Autowired
    private EstatisticaRepository estatisticaRepository;
    @Autowired
    private PartidaService partidaService;

    @Transactional
    public void create(String caminhoDoArquivo) throws IOException {
        try (CSVReader reader = new CSVReader(new FileReader(caminhoDoArquivo))) {

            String[] headers = reader.readNext();

            if (headers != null) {
                String[] linha;
                List<Estatistica> estatisticas = new ArrayList<>();
                while ((linha = reader.readNext()) != null) {
                    Long partidaId = Long.valueOf(linha[0]);
                    Partida partida = partidaService.findById(partidaId);

                    Estatistica estatistica = new Estatistica();
                    estatistica.setPartida(partida);
                    estatistica.setRodada(linha[1]);
                    estatistica.setChutes(linha[2]);
                    estatistica.setClube(linha[3]);
                    estatistica.setChutes_no_alvo(linha[4]);
                    estatistica.setPosse_De_bola(linha[5]);
                    estatistica.setPasses(linha[6]);
                    estatistica.setPrecisao_passes(linha[7]);
                    estatistica.setFaltas(linha[8]);
                    estatistica.setCartao_amarelo(linha[9]);
                    estatistica.setCartao_vermelho(linha[10]);
                    estatistica.setImpedimentos(linha[11]);
                    estatistica.setEscanteios(linha[12]);

                    estatisticas.add(estatistica);
                }
                List<Estatistica> estatisticasSalvas = estatisticaRepository.saveAll(estatisticas);
                for (Estatistica estatistica : estatisticasSalvas) {
                    estatistica.getPartida().getId();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResponseEntity<List<Estatistica>> findAll(){
        try {
            List<Estatistica> estatisticas = estatisticaRepository.findAll();
            return new ResponseEntity<>(estatisticas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public Estatistica findById(Long id) {
        return estatisticaRepository.findById(id).orElseThrow(() -> new ResourceNotFound("No records found for this id."));
    }
}
