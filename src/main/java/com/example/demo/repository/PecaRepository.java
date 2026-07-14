package com.example.demo.repository;

import com.example.demo.model.Peca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PecaRepository extends JpaRepository<Peca, Long> {
    
}
