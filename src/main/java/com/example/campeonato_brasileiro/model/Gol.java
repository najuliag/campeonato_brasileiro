package com.example.campeonato_brasileiro.model;

import jakarta.persistence.*;

@Entity
@Table(name = "gols")
public class Gol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_partida", referencedColumnName = "id")
    private Partida partida;
    private String rodada;
    private String clube;
    private String atleta;
    private String minuto;
    private String tipo_de_gol;


    public Gol() {
    }

    public Gol(Long id, String rodada, String clube, String atleta, String minuto, String tipo_de_gol, Partida partida) {
        this.id = id;
        this.rodada = rodada;
        this.clube = clube;
        this.atleta = atleta;
        this.minuto = minuto;
        this.tipo_de_gol = tipo_de_gol;
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

    public String getAtleta() {
        return atleta;
    }

    public void setAtleta(String atleta) {
        this.atleta = atleta;
    }

    public String getMinuto() {
        return minuto;
    }

    public void setMinuto(String minuto) {
        this.minuto = minuto;
    }

    public String getTipo_de_gol() {
        return tipo_de_gol;
    }

    public void setTipo_de_gol(String tipo_de_gol) {
        this.tipo_de_gol = tipo_de_gol;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }
}
