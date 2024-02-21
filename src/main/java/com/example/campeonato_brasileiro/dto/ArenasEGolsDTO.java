package com.example.campeonato_brasileiro.dto;

public class ArenasEGolsDTO {

    private String arena;
    private Long qntdGols;

    public ArenasEGolsDTO() {
    }

    public ArenasEGolsDTO(String arena, Long qntdGols) {
        this.arena = arena;
        this.qntdGols = qntdGols;
    }

    public String getArena() {
        return arena;
    }

    public void setArena(String arena) {
        this.arena = arena;
    }

    public Long getQntdGols() {
        return qntdGols;
    }

    public void setQntdGols(Long qntdGols) {
        this.qntdGols = qntdGols;
    }
}
