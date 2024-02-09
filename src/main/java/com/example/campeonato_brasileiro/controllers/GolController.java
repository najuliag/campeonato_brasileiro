package com.example.campeonato_brasileiro.controllers;

import com.example.campeonato_brasileiro.model.Cartao;
import com.example.campeonato_brasileiro.model.Gol;
import com.example.campeonato_brasileiro.services.GolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GolController {

    @Autowired
    private GolService golService;

    @PostMapping("/processar-csv-gol")
    public void create(@RequestParam("caminhoDoArquivo") String caminhoDoArquivo) throws IOException {
        golService.create(caminhoDoArquivo);
    }

    @GetMapping("/gols")
    public ResponseEntity<List<Gol>> findAll() {
        return golService.findAll();
    }

    @GetMapping(value = "gol/{id}")
    public Gol findById(@PathVariable Long id){
        return golService.findById(id);
    }
}
