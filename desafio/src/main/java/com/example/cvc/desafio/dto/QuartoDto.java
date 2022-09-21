package com.example.cvc.desafio.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuartoDto {

    @JsonProperty("roomID")
    private int id;

    @JsonProperty("categoryName")
    private String nomeCategoria;

    @JsonProperty("price")
    private PrecoDto preco;

}
