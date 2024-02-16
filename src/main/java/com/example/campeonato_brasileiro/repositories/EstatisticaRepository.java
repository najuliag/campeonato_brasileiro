package com.example.campeonato_brasileiro.repositories;

import com.example.campeonato_brasileiro.model.Estatistica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstatisticaRepository extends JpaRepository<Estatistica, Long> {
}
