package com.example.campeonato_brasileiro.repositories;

import com.example.campeonato_brasileiro.dto.CartoesDTO;
import com.example.campeonato_brasileiro.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long> {

    @Query("SELECT new com.example.campeonato_brasileiro.dto.CartoesDTO(c.clube, COUNT(c)) FROM Partida p JOIN p.cartoes c " +
            "WHERE STR_TO_DATE(p.data, '%d/%m/%Y') BETWEEN STR_TO_DATE('01/01/2020', '%d/%m/%Y') AND STR_TO_DATE('31/12/2022', '%d/%m/%Y') " +
            "AND c.cartao = 'AMARELO' GROUP BY c.clube ORDER BY COUNT(c) DESC")
    List<CartoesDTO> clubeComMaisCartoesAmarelos();

}

