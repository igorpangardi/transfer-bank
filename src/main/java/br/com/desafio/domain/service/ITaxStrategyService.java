package br.com.desafio.domain.service;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface ITaxStrategyService {
    BigDecimal calculateTax(LocalDate transferDate, BigDecimal transferAmount, LocalDate schedulingDate);
}
