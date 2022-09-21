package com.example.cvc.desafio.client;


import com.example.cvc.desafio.dto.HotelDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value="cvc", url="https://cvcbackendhotel.herokuapp.com")
public interface CvcClient {

     @GetMapping("/hotels/avail/{codigoCidade}")
     List<HotelDto> obterHoteis(@PathVariable String codigoCidade);
}
