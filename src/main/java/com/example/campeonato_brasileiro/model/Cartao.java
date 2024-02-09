package com.example.campeonato_brasileiro.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cartoes")
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String rodada;
    private String clube;
    private String cartao;
    private String atleta;
    private String num_camisa;
    private String posicao;
    private String minuto;
    @ManyToOne
    @JoinColumn(name = "id_partida", referencedColumnName = "id")
    private Partida partida;

    public Cartao() {}

    public Cartao(Long id, String rodada, String clube, String cartao, String atleta, String num_camisa, String posicao, String minuto, Partida partida) {
        this.id = id;
        this.rodada = rodada;
        this.clube = clube;
        this.cartao = cartao;
        this.atleta = atleta;
        this.num_camisa = num_camisa;
        this.posicao = posicao;
        this.minuto = minuto;
        this.partida = partida;
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

    public String getCartao() {
        return cartao;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }

    public String getAtleta() {
        return atleta;
    }

    public void setAtleta(String atleta) {
        this.atleta = atleta;
    }

    public String getNum_camisa() {
        return num_camisa;
    }

    public void setNum_camisa(String num_camisa) {
        this.num_camisa = num_camisa;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getMinuto() {
        return minuto;
    }

    public void setMinuto(String minuto) {
        this.minuto = minuto;
    }

    public Partida getPartida() { return partida; }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }
}
