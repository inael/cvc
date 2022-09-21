package com.example.cvc.desafio.service;

import com.example.cvc.desafio.client.CvcClient;
import com.example.cvc.desafio.dominio.CalculoDiariaHotel;
import com.example.cvc.desafio.dto.HotelDto;
import com.example.cvc.desafio.dto.OrcamentoHotelDto;
import com.example.cvc.desafio.dto.QuartoDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class HoteisService {

    private CvcClient cvcClient;
    private CalculoDiariaHotel calculoDiariaHotel;

    public List<OrcamentoHotelDto> obterOrcamentoHoteis(String codigoCidade) {
        List<HotelDto> hoteis = cvcClient.obterHoteis(codigoCidade);
        return hoteis.stream().map(hoteisDto -> {
            Optional<QuartoDto> quarto = hoteisDto
                    .getQuartos()
                    .stream().findFirst();
            float valor = 0;
            if (quarto.isPresent()) {

                valor = calculoDiariaHotel.calcularValor(quarto.get().getPreco().getAdulto(), quarto.get().getPreco().getCrianca());
            }
            return OrcamentoHotelDto.builder()
                    .nomeHotel(hoteisDto.getNomeHotel())
                    .nomeCidade(hoteisDto.getNomeCidade())
                    .valorTotal(valor)
                    .build();

        }).collect(Collectors.toList());


    }
}
