package com.thg.ms.currencyexchange.Controller;


import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuiteBreakerController {

    private Logger logger =
            LoggerFactory.getLogger(CircuiteBreakerController.class);

    // Não esta funcionando a dependencia,
//    @Retry(name="sample-api", fallbackMethod = "hardcodedResponse")
    @GetMapping("/sample-api")
//    @CircuitBreaker(name="default", fallbackMethod = "hardcodedResponse")
//    @RateLimiter(name = "default")
    @Bulkhead(name = "sample-api")
    //10s => 1000 calls to the sample api
    public String sampleApi(){
        logger.info("Sample Api call receveid");
        var forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url",
                String.class);

        return forEntity.getBody();
    }

    // pode usar qualquer exceção aqui dentro
    public String hardcodedResponse(Exception ex){
        return "fallback-response";
    }
}
