package br.com.desafio.domain.service.strategy;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface ITaxStrategy {

    BigDecimal calculateTax(LocalDate transferDate, BigDecimal transferAmount, LocalDate schedulingDate);
    boolean isApplicable(LocalDate transferDate, BigDecimal transferAmount, LocalDate schedulingDate);

}
