package br.com.desafio.domain.service.strategy.impl;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static br.com.desafio.domain.service.utils.TestConstants.*;
import static org.assertj.core.api.Assertions.assertThat;

class TaxStrategy1To10DaysTest {

    private final TaxStrategy1To10Days taxStrategy1To10Days = new TaxStrategy1To10Days();
    private static final LocalDate today = LocalDate.now();
    private static final BigDecimal FIXED_TAX_12 = new BigDecimal("12.00");

    @Test
    void shouldApplyTaxStrategyFor1To10Days() {
        // given
        LocalDate transferDate = today.plusDays(FIVE_DAYS);  // Entre 1 e 10 dias

        // when
        boolean isApplicable = taxStrategy1To10Days.isApplicable(transferDate, today);

        // then
        assertThat(isApplicable).isTrue();
    }

    @Test
    void shouldNotApplyTaxStrategyForMoreThan10Days() {
        // given
        LocalDate transferDate = today.plusDays(FIFTEEN_DAYS);  // Mais de 10 dias

        // when
        boolean isApplicable = taxStrategy1To10Days.isApplicable(transferDate, today);

        // then
        assertThat(isApplicable).isFalse();
    }

    @Test
    void shouldCalculateCorrectTaxFor1To10Days() {
        // given
        LocalDate transferDate = today.plusDays(FIVE_DAYS);  // Entre 1 e 10 dias

        // when
        BigDecimal tax = taxStrategy1To10Days.calculateTax(transferDate, AMOUNT_100, today);

        // then
        assertThat(tax).isEqualByComparingTo(FIXED_TAX_12);  // O valor da taxa é fixo (12.00)
    }

    @Test
    void shouldCalculateCorrectTaxForLargerAmount() {
        // given
        LocalDate transferDate = today.plusDays(FIVE_DAYS);  // Entre 1 e 10 dias

        // when
        BigDecimal tax = taxStrategy1To10Days.calculateTax(transferDate, AMOUNT_3852, today);

        // then
        assertThat(tax).isEqualByComparingTo(FIXED_TAX_12);  // O valor da taxa é fixo (12.00)
    }

}