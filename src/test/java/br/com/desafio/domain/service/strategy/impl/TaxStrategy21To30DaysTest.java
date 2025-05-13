package br.com.desafio.domain.service.strategy.impl;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static br.com.desafio.domain.service.strategy.impl.TestConstants.*;
import static org.assertj.core.api.Assertions.assertThat;

class TaxStrategy21To30DaysTest {

    private final TaxStrategy21To30Days taxStrategy21To30Days = new TaxStrategy21To30Days();

    @Test
    void shouldApplyTaxStrategyFor21To30Days() {
        // given
        LocalDate today = LocalDate.now();
        LocalDate transferDate = today.plusDays(TWENTY_FIVE_DAYS);  // Entre 21 e 30 dias

        // when
        boolean isApplicable = taxStrategy21To30Days.isApplicable(transferDate, AMOUNT_100, today);

        // then
        assertThat(isApplicable).isTrue();
    }

    @Test
    void shouldNotApplyTaxStrategyForMoreThan30Days() {
        // given
        LocalDate today = LocalDate.now();
        LocalDate transferDate = today.plusDays(THIRTY_FIVE_DAYS);  // Mais de 30 dias

        // when
        boolean isApplicable = taxStrategy21To30Days.isApplicable(transferDate, AMOUNT_100, today);

        // then
        assertThat(isApplicable).isFalse();
    }

    @Test
    void shouldNotApplyTaxStrategyForLessThan21Days() {
        // given
        LocalDate today = LocalDate.now();
        LocalDate transferDate = today.plusDays(TWENTY_DAYS);  // Menos de 21 dias

        // when
        boolean isApplicable = taxStrategy21To30Days.isApplicable(transferDate, AMOUNT_100, today);

        // then
        assertThat(isApplicable).isFalse();
    }

    @Test
    void shouldCalculateCorrectTaxFor21To30Days() {
        // given
        LocalDate today = LocalDate.now();
        LocalDate transferDate = today.plusDays(TWENTY_FIVE_DAYS);  // Entre 21 e 30 dias

        // when
        BigDecimal tax = taxStrategy21To30Days.calculateTax(transferDate, AMOUNT_100, today);

        // then
        assertThat(tax).isEqualByComparingTo(FIXED_TAX);
    }

    @Test
    void shouldCalculateCorrectTaxForLargerAmount() {
        // given
        LocalDate today = LocalDate.now();
        LocalDate transferDate = today.plusDays(TWENTY_FIVE_DAYS);  // Entre 21 e 30 dias

        // when
        BigDecimal tax = taxStrategy21To30Days.calculateTax(transferDate, AMOUNT_3852, today);

        // then
        assertThat(tax).isEqualByComparingTo(FIXED_TAX);
    }

}
