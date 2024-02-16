package com.example.campeonato_brasileiro.model;

import jakarta.persistence.*;

@Entity
@Table(name = "estatisticas")
public class Estatistica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_partida", referencedColumnName = "id")
    private Partida partida;
    private String rodada;
    private String clube;
    private String chutes;
    private String chutes_no_alvo;
    private String posse_De_bola;
    private String passes;
    private String precisao_passes;
    private String faltas;
    private String cartao_amarelo;
    private String cartao_vermelho;
    private String impedimentos;
    private String escanteios;


    public Estatistica() {
    }

    public Estatistica(Long id, String rodada, String clube, String chutes, String chutes_no_alvo, String posse_De_bola, String passes, String precisao_passes, String faltas, String cartao_amarelo, String cartao_vermelho, String impedimentos, String escanteios) {
        this.id = id;
        this.rodada = rodada;
        this.clube = clube;
        this.chutes = chutes;
        this.chutes_no_alvo = chutes_no_alvo;
        this.posse_De_bola = posse_De_bola;
        this.passes = passes;
        this.precisao_passes = precisao_passes;
        this.faltas = faltas;
        this.cartao_amarelo = cartao_amarelo;
        this.cartao_vermelho = cartao_vermelho;
        this.impedimentos = impedimentos;
        this.escanteios = escanteios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRodada() {
        return rodada;
    }

    public void setRodada(String rodada) {
        this.rodada = rodada;
    }

    public String getClube() {
        return clube;
    }

    public void setClube(String clube) {
        this.clube = clube;
    }

    public String getChutes() {
        return chutes;
    }

    public void setChutes(String chutes) {
        this.chutes = chutes;
    }

    public String getChutes_no_alvo() {
        return chutes_no_alvo;
    }

    public void setChutes_no_alvo(String chutes_no_alvo) {
        this.chutes_no_alvo = chutes_no_alvo;
    }

    public String getPosse_De_bola() {
        return posse_De_bola;
    }

    public void setPosse_De_bola(String posse_De_bola) {
        this.posse_De_bola = posse_De_bola;
    }

    public String getPasses() {
        return passes;
    }

    public void setPasses(String passes) {
        this.passes = passes;
    }

    public String getPrecisao_passes() {
        return precisao_passes;
    }

    public void setPrecisao_passes(String precisao_passes) {
        this.precisao_passes = precisao_passes;
    }

    public String getFaltas() {
        return faltas;
    }

    public void setFaltas(String faltas) {
        this.faltas = faltas;
    }

    public String getCartao_amarelo() {
        return cartao_amarelo;
    }

    public void setCartao_amarelo(String cartao_amarelo) {
        this.cartao_amarelo = cartao_amarelo;
    }

    public String getCartao_vermelho() {
        return cartao_vermelho;
    }

    public void setCartao_vermelho(String cartao_vermelho) {
        this.cartao_vermelho = cartao_vermelho;
    }

    public String getImpedimentos() {
        return impedimentos;
    }

    public void setImpedimentos(String impedimentos) {
        this.impedimentos = impedimentos;
    }

    public String getEscanteios() {
        return escanteios;
    }

    public void setEscanteios(String escanteios) {
        this.escanteios = escanteios;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }
}
