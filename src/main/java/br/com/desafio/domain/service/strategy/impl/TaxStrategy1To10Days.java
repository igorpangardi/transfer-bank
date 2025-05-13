package br.com.desafio.domain.service.strategy.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.desafio.domain.service.strategy.ITaxStrategy;
import org.springframework.stereotype.Component;

@Component
public class TaxStrategy1To10Days implements ITaxStrategy {

    private static final int MIN_DAYS = 1;
    private static final int MAX_DAYS = 10;
    private static final BigDecimal FIXED_TAX_12 = new BigDecimal("12.00");

    @Override
    public boolean isApplicable(LocalDate transferDate, LocalDate schedulingDate) {
        long days = ChronoUnit.DAYS.between(schedulingDate, transferDate);
        return days >= MIN_DAYS && days <= MAX_DAYS;
    }

    @Override
    public BigDecimal calculateTax(LocalDate transferDate, BigDecimal transferAmount, LocalDate schedulingDate) {
        return FIXED_TAX_12;
    }
}
