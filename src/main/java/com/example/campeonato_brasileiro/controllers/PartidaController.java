package com.example.campeonato_brasileiro.controllers;

import com.example.campeonato_brasileiro.model.Partida;
import com.example.campeonato_brasileiro.services.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PartidaController {

        @Autowired
        private PartidaService partidaService;

        @PostMapping("/processar-csv-partida")
        public void create(@RequestParam("caminhoDoArquivo") String caminhoDoArquivo) throws IOException {
            partidaService.create(caminhoDoArquivo);
        }
        @GetMapping("/partidas")
        public ResponseEntity<List<Partida>> findAll() {
            return partidaService.findAll();
        }

        @GetMapping(value = "partida/{id}")
        public Partida findById(@PathVariable Long id){
            return partidaService.findById(id);
        }
    }