package com.example.campeonato_brasileiro.repositories;

import com.example.campeonato_brasileiro.model.Gol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GolRepository extends JpaRepository<Gol, Long> {
}
