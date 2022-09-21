package com.example.cvc.desafio.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class HotelDto {

    private int id;

    @JsonProperty("name")
    private String nomeHotel;

    @JsonProperty("cityCode")
    private int codigoCidade;

    @JsonProperty("cityName")
    private String nomeCidade;

    @JsonProperty("rooms")
    List<QuartoDto> quartos;

}
