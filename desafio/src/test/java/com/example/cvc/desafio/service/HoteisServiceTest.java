package com.example.cvc.desafio.service;

import com.example.cvc.desafio.client.CvcClient;
import com.example.cvc.desafio.dto.HotelDto;
import com.example.cvc.desafio.dto.OrcamentoHotelDto;
import com.example.cvc.desafio.dto.PrecoDto;
import com.example.cvc.desafio.dto.QuartoDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class HoteisServiceTest {


    public static final String COD_PORTO_SEGURO = "1032";
    public static final String HOTEL_TESTE_1 = "Hotel Teste 1";
    public static final float PRECO_ADULTO = 1372.54f;
    public static final float PRECO_CRIANCA = 848.61f;
    @Mock
    private CvcClient cvcClient;

    @Autowired
    private HoteisService service;
    @Mock
    private HotelDto hotelMock;

    @Mock
    private QuartoDto quartoMock;
    @Mock
    private PrecoDto precoMock;

    @Test
    public void deveriaCalcularOrcamentoHotel() {
        List<HotelDto> hoteis = new ArrayList<>();
        hoteis.add(hotelMock);
        when(cvcClient.obterHoteis(any())).thenReturn(hoteis);


        List<QuartoDto> quartos = new ArrayList<>();
        quartos.add(quartoMock);
        when(hotelMock.getNomeHotel()).thenReturn(HOTEL_TESTE_1);
        when(hotelMock.getQuartos()).thenReturn(quartos);
        when(quartoMock.getPreco()).thenReturn(precoMock);
        when(precoMock.getAdulto()).thenReturn(PRECO_ADULTO);
        when(precoMock.getAdulto()).thenReturn(PRECO_CRIANCA);

        float valorHotelEsperado = ((2 * PRECO_ADULTO) + PRECO_CRIANCA);

        OrcamentoHotelDto orcamento = service.obterOrcamentoHoteis(COD_PORTO_SEGURO)
                .stream()
                .filter(orcamentoHotelDto -> orcamentoHotelDto.getNomeHotel().equals(HOTEL_TESTE_1)).findFirst().get();

        assertEquals(valorHotelEsperado, orcamento.getValorTotal());
    }
}