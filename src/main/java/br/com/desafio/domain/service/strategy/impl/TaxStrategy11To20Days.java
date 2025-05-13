package br.com.desafio.domain.service.strategy.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.desafio.domain.service.strategy.ITaxStrategy;
import org.springframework.stereotype.Component;

@Component
public class TaxStrategy11To20Days implements ITaxStrategy {

    private static final int MIN_DAYS = 11;
    private static final int MAX_DAYS = 20;
    private static final BigDecimal PERCENTAGE_TAX = new BigDecimal("0.082");

    @Override
    public boolean isApplicable(LocalDate transferDate, LocalDate schedulingDate) {
        long days = ChronoUnit.DAYS.between(schedulingDate, transferDate);
        return days >= MIN_DAYS && days <= MAX_DAYS;
    }

    @Override
    public BigDecimal calculateTax(LocalDate transferDate, BigDecimal transferAmount, LocalDate schedulingDate) {
        return transferAmount.multiply(PERCENTAGE_TAX);
    }
}
