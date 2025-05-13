package br.com.desafio.domain.service.strategy.impl;

import br.com.desafio.domain.service.strategy.ITaxStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class SameDayTaxStrategy implements ITaxStrategy {

    private static final BigDecimal SAME_DAY_FIXED_TAX = new BigDecimal("3.00");
    private static final BigDecimal SAME_DAY_PERCENT_TAX = new BigDecimal("0.025");

    @Override
    public boolean isApplicable(LocalDate transferDate, LocalDate schedulingDate) {
        return transferDate.equals(schedulingDate);
    }

    @Override
    public BigDecimal calculateTax(LocalDate transferDate, BigDecimal transferAmount, LocalDate schedulingDate) {
        BigDecimal percentageTax = transferAmount.multiply(SAME_DAY_PERCENT_TAX);
        return SAME_DAY_FIXED_TAX.add(percentageTax);
    }

}
