package com.example.ConsumoApi.Model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String foto;
    @Column(nullable = false)
    private Double preco;
}
