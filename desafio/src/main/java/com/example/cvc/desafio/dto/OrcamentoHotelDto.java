package com.example.cvc.desafio.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class OrcamentoHotelDto {

    private String nomeHotel;
    private String nomeCidade;
    private float valorTotal;
}
