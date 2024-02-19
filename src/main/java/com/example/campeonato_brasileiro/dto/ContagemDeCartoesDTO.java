package com.example.campeonato_brasileiro.dto;

public class ContagemDeCartoesDTO {

    private String clube;
    private Long quantidadeCartoesAmarelos;

    public ContagemDeCartoesDTO(String clube, Long quantidadeCartoesAmarelos) {
        this.clube = clube;
        this.quantidadeCartoesAmarelos = quantidadeCartoesAmarelos;
    }

    public ContagemDeCartoesDTO() {
    }

    public String getClube() {
        return clube;
    }

    public void setClube(String clube) {
        this.clube = clube;
    }

    public Long getQuantidadeCartoesAmarelos() {
        return quantidadeCartoesAmarelos;
    }

    public void setQuantidadeCartoesAmarelos(Long quantidadeCartoesAmarelos) {
        this.quantidadeCartoesAmarelos = quantidadeCartoesAmarelos;
    }
}
