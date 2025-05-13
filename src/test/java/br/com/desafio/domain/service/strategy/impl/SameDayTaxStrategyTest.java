package br.com.desafio.domain.service.strategy.impl;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static br.com.desafio.domain.service.strategy.impl.TestConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

class SameDayTaxStrategyTest {

    private final SameDayTaxStrategy sameDayTaxStrategy = new SameDayTaxStrategy();
    private static final BigDecimal SAME_DAY_FIXED_TAX = new BigDecimal("3");
    private static final BigDecimal SAME_DAY_PERCENT_TAX = new BigDecimal("0.025");
    private static final LocalDate today = LocalDate.now();

    @Test
    void shouldApplySameDayStrategy() {
        boolean isApplicable = sameDayTaxStrategy.isApplicable(today, today);
        assertThat(isApplicable).isTrue();
    }

    @Test
    void shouldNotApplySameDayStrategy() {
        boolean isApplicable = sameDayTaxStrategy.isApplicable(today, today.plusDays(ONE_DAY));
        assertThat(isApplicable).isFalse();
    }

    @Test
    void shouldCalculateCorrectSameDayTax() {
        BigDecimal tax = sameDayTaxStrategy.calculateTax(today, AMOUNT_100, today);
        BigDecimal expectedTax = SAME_DAY_FIXED_TAX.add(AMOUNT_100.multiply(SAME_DAY_PERCENT_TAX));
        assertThat(tax).isEqualByComparingTo(expectedTax);
    }

    @Test
    void shouldCalculateCorrectTaxForLargerAmount() {
        BigDecimal tax = sameDayTaxStrategy.calculateTax(today, AMOUNT_3852, today);
        BigDecimal expectedTax = SAME_DAY_FIXED_TAX.add(AMOUNT_3852.multiply(SAME_DAY_PERCENT_TAX));
        assertThat(tax).isEqualByComparingTo(expectedTax);
    }

}
