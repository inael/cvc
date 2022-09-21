package com.example.cvc.desafio.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PrecoDto {

    @JsonProperty("adult")
    private float adulto;

    @JsonProperty("child")
    private float crianca;
}
