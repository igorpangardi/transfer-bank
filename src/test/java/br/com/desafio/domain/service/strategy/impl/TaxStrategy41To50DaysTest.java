package br.com.desafio.domain.service.strategy.impl;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static br.com.desafio.domain.service.utils.TestConstants.*;
import static org.assertj.core.api.Assertions.assertThat;

class TaxStrategy41To50DaysTest {

    private final TaxStrategy41To50Days strategy = new TaxStrategy41To50Days();
    private static final BigDecimal PERCENTAGE_TAX = new BigDecimal("0.017");
    private static final LocalDate today = LocalDate.now();

    @Test
    void shouldApplyTaxStrategyFor41To50Days() {
        // given
        LocalDate transferDate = today.plusDays(FORTY_TWO_DAYS);  // Entre 41 e 50 dias

        // when
        boolean isApplicable = strategy.isApplicable(transferDate, today);

        // then
        assertThat(isApplicable).isTrue();
    }

    @Test
    void shouldNotApplyTaxStrategyForLessThan41Days() {
        // given
        LocalDate transferDate = today.plusDays(FORTY_DAYS);  // Menos de 41 dias

        // when
        boolean isApplicable = strategy.isApplicable(transferDate, today);

        // then
        assertThat(isApplicable).isFalse();
    }

    @Test
    void shouldNotApplyTaxStrategyForMoreThan50Days() {
        // given
        LocalDate transferDate = today.plusDays(FIFTY_ONE_DAYS);  // Mais de 50 dias

        // when
        boolean isApplicable = strategy.isApplicable(transferDate, today);

        // then
        assertThat(isApplicable).isFalse();
    }

    @Test
    void shouldCalculateCorrectTaxFor41To50Days() {
        // given
        LocalDate transferDate = today.plusDays(FORTY_FIVE_DAYS);  // Entre 41 e 50 dias

        // when
        BigDecimal tax = strategy.calculateTax(transferDate, AMOUNT_100, today);
        BigDecimal expectedTax = AMOUNT_100.multiply(PERCENTAGE_TAX);

        // then
        assertThat(tax).isEqualByComparingTo(expectedTax);
    }

    @Test
    void shouldCalculateCorrectTaxForLargerAmount() {
        // given
        LocalDate transferDate = today.plusDays(FORTY_FIVE_DAYS);  // Entre 41 e 50 dias

        // when
        BigDecimal tax = strategy.calculateTax(transferDate, AMOUNT_3852, today);
        BigDecimal expectedTax = AMOUNT_3852.multiply(PERCENTAGE_TAX);

        // then
        assertThat(tax).isEqualByComparingTo(expectedTax);
    }
}
