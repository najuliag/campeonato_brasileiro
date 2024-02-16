package com.example.campeonato_brasileiro.controllers;

import com.example.campeonato_brasileiro.model.Cartao;
import com.example.campeonato_brasileiro.model.Estatistica;
import com.example.campeonato_brasileiro.services.EstatisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/estatistica")
public class EstatisticaController {

    @Autowired
    private EstatisticaService estatisticaService;

    @PostMapping("/processar-csv")
    public void create(@RequestParam("caminhoDoArquivo") String caminhoDoArquivo) throws IOException {
        estatisticaService.create(caminhoDoArquivo);
    }

    @GetMapping("/estatisticas")
    public ResponseEntity<List<Estatistica>> findAll() {
        return estatisticaService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Estatistica findById(@PathVariable Long id){
        return estatisticaService.findById(id);
    }
}
