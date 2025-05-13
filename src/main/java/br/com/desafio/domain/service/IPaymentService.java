package br.com.desafio.domain.service;

import br.com.desafio.domain.model.Payment;

import java.util.List;

public interface IPaymentService {
    Payment createSchedulingPayment(Payment payment);
    List<Payment> getPayments();
}
