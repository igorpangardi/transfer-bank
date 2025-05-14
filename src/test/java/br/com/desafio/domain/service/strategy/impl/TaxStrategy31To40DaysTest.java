package br.com.desafio.domain.service.strategy.impl;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static br.com.desafio.domain.service.utils.TestConstants.*;
import static org.assertj.core.api.Assertions.assertThat;

class TaxStrategy31To40DaysTest {

    private final TaxStrategy31To40Days strategy = new TaxStrategy31To40Days();
    private static final BigDecimal PERCENTAGE_TAX = new BigDecimal("0.047");
    private static final LocalDate today = LocalDate.now();

    @Test
    void shouldApplyTaxStrategyFor31To40Days() {
        // given
        LocalDate transferDate = today.plusDays(THIRTY_FIVE_DAYS);  // Entre 31 e 40 dias

        // when
        boolean isApplicable = strategy.isApplicable(transferDate, today);

        // then
        assertThat(isApplicable).isTrue();
    }

    @Test
    void shouldNotApplyTaxStrategyForLessThan31Days() {
        // given
        LocalDate transferDate = today.plusDays(TWENTY_DAYS);  // Menos de 31 dias

        // when
        boolean isApplicable = strategy.isApplicable(transferDate, today);

        // then
        assertThat(isApplicable).isFalse();
    }

    @Test
    void shouldNotApplyTaxStrategyForMoreThan40Days() {
        // given
        LocalDate transferDate = today.plusDays(FIFTY_DAYS);  // Mais de 40 dias

        // when
        boolean isApplicable = strategy.isApplicable(transferDate, today);

        // then
        assertThat(isApplicable).isFalse();
    }

    @Test
    void shouldCalculateCorrectTaxFor31To40Days() {
        // given
        LocalDate transferDate = today.plusDays(THIRTY_FIVE_DAYS);  // Entre 31 e 40 dias

        // when
        BigDecimal tax = strategy.calculateTax(transferDate, AMOUNT_100, today);
        BigDecimal expectedTax = AMOUNT_100.multiply(PERCENTAGE_TAX);

        // then
        assertThat(tax).isEqualByComparingTo(expectedTax);
    }

    @Test
    void shouldCalculateCorrectTaxForLargerAmount() {
        // given
        LocalDate transferDate = today.plusDays(THIRTY_FIVE_DAYS);  // Entre 31 e 40 dias

        // when
        BigDecimal tax = strategy.calculateTax(transferDate, AMOUNT_3852, today);
        BigDecimal expectedTax = AMOUNT_3852.multiply(PERCENTAGE_TAX);

        // then
        assertThat(tax).isEqualByComparingTo(expectedTax);
    }
}
