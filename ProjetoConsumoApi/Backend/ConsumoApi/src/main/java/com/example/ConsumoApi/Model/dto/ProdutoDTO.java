package com.example.ConsumoApi.Model.dto;

import lombok.Data;

@Data
public class ProdutoDTO {
    private Long id;
    private String nome;
    private String foto;
    private Double preco;
}
