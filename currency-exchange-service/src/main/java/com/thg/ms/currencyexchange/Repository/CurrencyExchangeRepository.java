package com.thg.ms.currencyexchange.Repository;

import com.thg.ms.currencyexchange.Bean.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
    CurrencyExchange findByFromAndTo(String from, String to);
    CurrencyExchange findByconversionMultiple(BigDecimal conversionMultiple);

}
