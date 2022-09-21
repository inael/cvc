package com.example.cvc.desafio.dominio;

import org.springframework.stereotype.Service;

@Service
public class CalculoDiariaHotelFamiliaPequena implements CalculoDiariaHotel {
    private static final float QTD_ADULTO = 2;

    @Override
    public float calcularValor(float precoAdulto, float precoCrianca) {
        return (QTD_ADULTO * precoAdulto) + precoCrianca;
    }
}
