package com.example.campeonato_brasileiro.repositories;

import com.example.campeonato_brasileiro.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long> {
}
