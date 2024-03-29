package com.example.campeonato_brasileiro.controllers;

import com.example.campeonato_brasileiro.dto.ArenasEGolsDTO;
import com.example.campeonato_brasileiro.dto.CartoesDTO;
import com.example.campeonato_brasileiro.dto.EstatisticaDTO;
import com.example.campeonato_brasileiro.model.Partida;
import com.example.campeonato_brasileiro.services.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/partida")
public class PartidaController {

        @Autowired
        private PartidaService partidaService;

        @PostMapping("/processar-csv")
        public void create(@RequestParam("caminhoDoArquivo") String caminhoDoArquivo) throws IOException {
            partidaService.create(caminhoDoArquivo);
        }
        @GetMapping("/partidas")
        public ResponseEntity<List<Partida>> findAll() {
            return partidaService.findAll();
        }

        @GetMapping(value = "/{id}")
        public Partida findById(@PathVariable Long id){
            return partidaService.findById(id);
        }

    @GetMapping("/clube-com-mais-cartoes-amarelos/{ano}")
    public CartoesDTO clubeComMaisCartoesAmarelos(@PathVariable String ano) {
        return partidaService.clubeComMaisCartoesAmarelos(ano);
    }

    @GetMapping("/arena-com-mais-gols")
    public ArenasEGolsDTO arenaComMaisGols(){
            return partidaService.arenaComMaisGols();
    }

    @GetMapping("/clubes-mais-precisos")
    public EstatisticaDTO obterClubesMaisPrecisos() {
        return partidaService.clubeComMaiorPrecisao();
    }
}
