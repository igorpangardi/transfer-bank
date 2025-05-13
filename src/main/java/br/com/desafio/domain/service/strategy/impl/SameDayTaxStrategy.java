package br.com.desafio.domain.service.strategy.impl;

import br.com.desafio.domain.service.strategy.ITaxStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class SameDayTaxStrategy implements ITaxStrategy {

    @Override
    public boolean isApplicable(LocalDate transferDate, BigDecimal transferAmount, LocalDate schedulingDate) {
        return transferDate.equals(schedulingDate);
    }

    @Override
    public BigDecimal calculateTax(LocalDate transferDate, BigDecimal transferAmount, LocalDate schedulingDate) {
        BigDecimal fixedTax = BigDecimal.valueOf(3.00);
        BigDecimal percentageTax = transferAmount.multiply(BigDecimal.valueOf(0.025));
        return fixedTax.add(percentageTax);
    }

}
