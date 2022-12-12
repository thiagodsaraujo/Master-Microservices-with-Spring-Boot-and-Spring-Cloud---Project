package com.thg.ms.currencyconversion.proxy;

import com.thg.ms.currencyconversion.Bean.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Nome da aplicação no eureka e o url do microservice
//@FeignClient(name = "currency-exchange", url = "localhost:8000")
//desde que duas instanciais do serviço chamado esteja online
// o loadbalancer ja vem com o eureka client em seu path
@FeignClient(name = "currency-exchange") // ele tirou a url, para setar o load balancing e funcionou.
public interface CurrencyExchangeProxy {


    // como o ms de conversao e de exchange tem os mesmos valores ele só mudou o retorno
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValue(
            @PathVariable String from,
            @PathVariable String to);
}
