package com.example.campeonato_brasileiro.dto;

public class EstatisticaDTO {
    private String clube;
    private String precisao;
    public EstatisticaDTO(String clube, String precisao) {
        this.clube = clube;
    }

    public String getPrecisao() {

        return precisao;
    }

    public void setPrecisao(String precisao) {
        this.precisao = precisao;
    }

    public String getClube() {
        return clube;
    }

    public void setClube(String clube) {
        this.clube = clube;
    }
}
