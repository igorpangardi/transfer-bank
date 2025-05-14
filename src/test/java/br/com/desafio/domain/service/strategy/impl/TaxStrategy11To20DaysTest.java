package br.com.desafio.domain.service.strategy.impl;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static br.com.desafio.domain.service.utils.TestConstants.*;
import static org.assertj.core.api.Assertions.assertThat;

class TaxStrategy11To20DaysTest {

    private final TaxStrategy11To20Days taxStrategy11To20Days = new TaxStrategy11To20Days();
    private static final LocalDate today = LocalDate.now();
    private static final BigDecimal PERCENTAGE_TAX = new BigDecimal("0.082");

    @Test
    void shouldApplyTaxStrategyFor11To20Days() {
        // given
        LocalDate transferDate = today.plusDays(FIFTEEN_DAYS);  // Entre 11 e 20 dias

        // when
        boolean isApplicable = taxStrategy11To20Days.isApplicable(transferDate, today);

        // then
        assertThat(isApplicable).isTrue();
    }

    @Test
    void shouldNotApplyTaxStrategyForMoreThan20Days() {
        // given
        LocalDate transferDate = today.plusDays(TWENTY_FIVE_DAYS);  // Mais de 20 dias

        // when
        boolean isApplicable = taxStrategy11To20Days.isApplicable(transferDate, today);

        // then
        assertThat(isApplicable).isFalse();
    }

    @Test
    void shouldNotApplyTaxStrategyForLessThan11Days() {
        // given
        LocalDate transferDate = today.plusDays(TEN_DAYS);  // Menos de 11 dias

        // when
        boolean isApplicable = taxStrategy11To20Days.isApplicable(transferDate, today);

        // then
        assertThat(isApplicable).isFalse();
    }

    @Test
    void shouldCalculateCorrectTaxFor11To20Days() {
        // given
        LocalDate transferDate = today.plusDays(FIFTEEN_DAYS);  // Entre 11 e 20 dias

        // when
        BigDecimal tax = taxStrategy11To20Days.calculateTax(transferDate, AMOUNT_100, today);
        BigDecimal expectedTax = AMOUNT_100.multiply(PERCENTAGE_TAX);

        // then
        assertThat(tax).isEqualByComparingTo(expectedTax);
    }

    @Test
    void shouldCalculateCorrectTaxForLargerAmount() {
        // given
        LocalDate transferDate = today.plusDays(FIFTEEN_DAYS);  // Entre 11 e 20 dias

        // when
        BigDecimal tax = taxStrategy11To20Days.calculateTax(transferDate, AMOUNT_3852, today);
        BigDecimal expectedTax = AMOUNT_3852.multiply(PERCENTAGE_TAX);

        // then
        assertThat(tax).isEqualByComparingTo(expectedTax);
    }

}
