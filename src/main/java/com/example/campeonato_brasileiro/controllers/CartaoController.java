package com.example.campeonato_brasileiro.controllers;

import com.example.campeonato_brasileiro.model.Cartao;
import com.example.campeonato_brasileiro.services.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/cartao")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @PostMapping("/processar-csv")
    public void create(@RequestParam("caminhoDoArquivo") String caminhoDoArquivo) throws IOException {
        cartaoService.create(caminhoDoArquivo);
    }

    @GetMapping("/cartoes")
    public ResponseEntity<List<Cartao>> findAll() {
        return cartaoService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Cartao findById(@PathVariable Long id){
        return cartaoService.findById(id);
    }

}
