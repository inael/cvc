package com.example.cvc.desafio.restapi;


import com.example.cvc.desafio.dto.OrcamentoHotelDto;
import com.example.cvc.desafio.service.HoteisService;
import feign.Param;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class HotelController {

    @Autowired
    private HoteisService service;

    @ApiOperation("Retorna uma lista de hoteis pelo código da cidade")
    @GetMapping("/hoteis/{codigoCidade}")
    public ResponseEntity<List<OrcamentoHotelDto>> obterOrcamentoHoteis(@PathVariable String codigoCidade){
        return ResponseEntity.ok(service.obterOrcamentoHoteis(codigoCidade));
    }
}
