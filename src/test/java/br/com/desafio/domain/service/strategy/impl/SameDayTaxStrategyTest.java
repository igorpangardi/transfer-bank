package br.com.desafio.domain.service.strategy.impl;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static br.com.desafio.domain.service.strategy.impl.TestConstants.*;
import static org.assertj.core.api.Assertions.assertThat;

class SameDayTaxStrategyTest {

    private final SameDayTaxStrategy sameDayTaxStrategy = new SameDayTaxStrategy();

    @Test
    void shouldApplySameDayStrategy() {
        // given
        LocalDate today = LocalDate.now();

        // when
        boolean isApplicable = sameDayTaxStrategy.isApplicable(today, AMOUNT_100, today);

        // then
        assertThat(isApplicable).isTrue();
    }

    @Test
    void shouldNotApplySameDayStrategy() {
        // given
        LocalDate today = LocalDate.now();

        // when
        boolean isApplicable = sameDayTaxStrategy.isApplicable(today, AMOUNT_100, today.plusDays(ONE_DAY));

        // then
        assertThat(isApplicable).isFalse();
    }

    @Test
    void shouldCalculateCorrectSameDayTax() {
        // given
        LocalDate today = LocalDate.now();

        // when
        BigDecimal tax = sameDayTaxStrategy.calculateTax(today, AMOUNT_100, today);
        BigDecimal expectedTax = FIXED_TAX.add(AMOUNT_100.multiply(PERCENTAGE));

        // then
        assertThat(tax).isEqualByComparingTo(expectedTax);
    }

    @Test
    void shouldCalculateCorrectTaxForLargerAmount() {
        // given
        LocalDate today = LocalDate.now();

        // when
        BigDecimal tax = sameDayTaxStrategy.calculateTax(today, AMOUNT_3852, today);
        BigDecimal expectedTax = FIXED_TAX.add(AMOUNT_3852.multiply(PERCENTAGE));

        // then
        assertThat(tax).isEqualByComparingTo(expectedTax);
    }

}
