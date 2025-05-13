package br.com.desafio.domain.service.impl;

import br.com.desafio.domain.model.Payment;
import br.com.desafio.domain.repository.PaymentRepository;
import br.com.desafio.domain.service.IPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService implements IPaymentService {

    private final PaymentRepository paymentRepository;
    private final TaxStrategyService taxStrategyService;

    @Override
    public Payment createSchedulingPayment(Payment entity) {
        var tax = taxStrategyService.calculateTax(entity.getTransferDate(), entity.getTransferAmount(), LocalDate.now());
        entity.builder(tax, LocalDate.now());
        return paymentRepository.save(entity);
    }

    @Override
    public List<Payment> getPayments() {
        return paymentRepository.findAll();
    }

}
