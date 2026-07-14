package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "pecas")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Peca {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    private String codigo;

    @Column(name = "preco_unitario")
    private Double precoUnitario;
}
