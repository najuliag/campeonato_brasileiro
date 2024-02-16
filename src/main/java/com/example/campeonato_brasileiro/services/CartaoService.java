package com.example.campeonato_brasileiro.services;

import com.example.campeonato_brasileiro.exceptions.ResourceNotFound;
import com.example.campeonato_brasileiro.model.Cartao;
import com.example.campeonato_brasileiro.repositories.CartaoRepository;
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
public class CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;
    @Autowired
    private PartidaService partidaService;

    @Transactional
    public List<Long> create(String caminhoDoArquivo) throws IOException {
        List<Long> idsPartidas = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(caminhoDoArquivo))) {
            String[] headers = reader.readNext();

            if (headers != null) {
                String[] linha;
                List<Cartao> cartoes = new ArrayList<>();
                while ((linha = reader.readNext()) != null) {
                    Cartao cartao = new Cartao();
                    cartao.setPartida(partidaService.findById(Long.parseLong(linha[0])));
                    cartao.setRodada(linha[1]);
                    cartao.setClube(linha[2]);
                    cartao.setCartao(linha[3]);
                    cartao.setAtleta(linha[4]);
                    cartao.setNum_camisa(linha[5]);
                    cartao.setPosicao(linha[6]);
                    cartao.setMinuto(linha[7]);
                    cartoes.add(cartao);
                }
                List<Cartao> cartoesSalvos = cartaoRepository.saveAll(cartoes);
                for (Cartao cartao : cartoesSalvos) {
                    idsPartidas.add(cartao.getPartida().getId());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return idsPartidas;
    }

    public ResponseEntity<List<Cartao>> findAll(){
        try {
            List<Cartao> cartoes = cartaoRepository.findAll();
            return new ResponseEntity<>(cartoes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public Cartao findById(Long id) {
        return cartaoRepository.findById(id).orElseThrow(() -> new ResourceNotFound("No records found for this id."));
    }
}
