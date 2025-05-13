package br.com.desafio.domain.service.impl;

import br.com.desafio.exception.NoApplicableTaxException;
import br.com.desafio.domain.service.ITaxStrategyService;
import br.com.desafio.domain.service.strategy.ITaxStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaxStrategyService implements ITaxStrategyService {

    private final List<ITaxStrategy> strategies;

    @Override
    public BigDecimal calculateTax(LocalDate transferDate, BigDecimal transferAmount, LocalDate schedulingDate) {
        return strategies.stream()
                .filter(strategy -> strategy.isApplicable(transferDate, transferAmount, schedulingDate))
                .findFirst()
                .map(strategy -> strategy.calculateTax(transferDate, transferAmount, schedulingDate))
                .orElseThrow(() -> new NoApplicableTaxException("There is no applicable tax for this transfer."))
                .setScale(2, RoundingMode.HALF_UP);
    }
}
