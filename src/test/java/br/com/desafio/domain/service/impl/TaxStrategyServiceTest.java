package br.com.desafio.domain.service.impl;

import br.com.desafio.domain.repository.PaymentRepository;
import br.com.desafio.domain.service.strategy.ITaxStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TaxStrategyServiceTest {

    @Mock
    private List<ITaxStrategy> strategies;

    @InjectMocks
    private TaxStrategyService paymentService;

}
