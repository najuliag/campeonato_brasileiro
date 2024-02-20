package com.example.campeonato_brasileiro.dto;

public class CartoesDTO {

    private String clube;
    private Long qntdCartoes;

    public CartoesDTO(String clube, Long qntdCartoes) {
        this.clube = clube;
        this.qntdCartoes = qntdCartoes;
    }

    public CartoesDTO() {
    }

    public String getClube() {
        return clube;
    }

    public void setClube(String clube) {
        this.clube = clube;
    }

    public Long getQntdCartoes() {
        return qntdCartoes;
    }

    public void setQntdCartoes(Long qntdCartoes) {
        this.qntdCartoes = qntdCartoes;
    }
}
