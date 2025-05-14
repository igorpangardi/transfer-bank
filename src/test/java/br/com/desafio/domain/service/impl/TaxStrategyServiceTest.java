package br.com.desafio.domain.service.impl;

import br.com.desafio.domain.service.strategy.ITaxStrategy;
import br.com.desafio.domain.service.strategy.impl.*;
import br.com.desafio.exception.NoApplicableTaxException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static br.com.desafio.domain.service.utils.TestConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TaxStrategyServiceTest {

    private TaxStrategyService taxStrategyService;
    private static final LocalDate today = LocalDate.now();
    private static final BigDecimal AMOUNT_150 = new BigDecimal("150.00");

    @BeforeEach
    void setUp() {
        List<ITaxStrategy> strategies = List.of(
                new SameDayTaxStrategy(),
                new TaxStrategy1To10Days(),
                new TaxStrategy11To20Days(),
                new TaxStrategy21To30Days(),
                new TaxStrategy31To40Days(),
                new TaxStrategy41To50Days()
        );
        taxStrategyService = new TaxStrategyService(strategies);
    }

    @Test
    void shouldCalculateTaxForSameDayStrategy() {
        final String expected = "6.75"; // 2.5%
        BigDecimal tax = taxStrategyService.calculateTax(today, AMOUNT_150, today);
        assertThat(tax).isEqualByComparingTo(new BigDecimal(expected));
    }

    @Test
    void shouldCalculateTaxFor1To10DayStrategy() {
        final String expected = "12.00"; // 0.0 fixed tax
        BigDecimal tax = taxStrategyService.calculateTax(today.plusDays(ONE_DAY), AMOUNT_150, today);
        assertThat(tax).isEqualByComparingTo(new BigDecimal(expected));
    }

    @Test
    void shouldCalculateTaxFor11To20DayStrategy() {
        final String expected = "12.30"; // 8.2%
        BigDecimal tax = taxStrategyService.calculateTax(today.plusDays(FIFTEEN_DAYS), AMOUNT_150, today);
        assertThat(tax).isEqualByComparingTo(new BigDecimal(expected));
    }

    @Test
    void shouldCalculateTaxFor21To30DayStrategy() {
        final String expected = "10.35"; // 6.9%
        BigDecimal tax = taxStrategyService.calculateTax(today.plusDays(TWENTY_FIVE_DAYS), AMOUNT_150, today);
        assertThat(tax).isEqualByComparingTo(new BigDecimal(expected));
    }

    @Test
    void shouldCalculateTaxFor31To40DayStrategy() {
        final String expected = "7.05"; // 4.7%
        BigDecimal tax = taxStrategyService.calculateTax(today.plusDays(THIRTY_FIVE_DAYS), AMOUNT_150, today);
        assertThat(tax).isEqualByComparingTo(new BigDecimal(expected));
    }

    @Test
    void shouldCalculateTaxFor41To50DayStrategy() {
        final String expected = "2.55"; // 1.7
        BigDecimal tax = taxStrategyService.calculateTax(today.plusDays(FORTY_FIVE_DAYS), AMOUNT_150, today);
        assertThat(tax).isEqualByComparingTo(new BigDecimal(expected));
    }

    @Test
    void shouldThrowExceptionWhenNoStrategyApplies() {
        assertThrows(NoApplicableTaxException.class, () ->
                taxStrategyService.calculateTax(today.plusDays(FIFTY_ONE_DAYS), AMOUNT_150, today)
        );
    }
}
