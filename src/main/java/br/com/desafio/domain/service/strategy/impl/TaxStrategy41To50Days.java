package br.com.desafio.domain.service.strategy.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.desafio.domain.service.strategy.ITaxStrategy;
import org.springframework.stereotype.Component;

@Component
public class TaxStrategy41To50Days implements ITaxStrategy {

    @Override
    public boolean isApplicable(LocalDate transferDate, BigDecimal transferAmount, LocalDate schedulingDate) {
        long days = ChronoUnit.DAYS.between(schedulingDate, transferDate);
        return days >= 41 && days <= 50;
    }

    @Override
    public BigDecimal calculateTax(LocalDate transferDate, BigDecimal transferAmount, LocalDate schedulingDate) {
        return BigDecimal.valueOf(1.7);
    }

}
