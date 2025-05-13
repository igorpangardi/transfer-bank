package br.com.desafio.api.v1.controller;

import java.util.List;

import javax.validation.Valid;

import br.com.desafio.api.v1.dto.request.PaymentRequest;
import br.com.desafio.api.v1.dto.response.PaymentResponse;
import br.com.desafio.api.v1.mapper.PaymentMapper;
import br.com.desafio.domain.model.Payment;
import br.com.desafio.domain.service.IPaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final IPaymentService paymentService;
    private final PaymentMapper paymentMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PaymentResponse> geyPayments() {
        return paymentMapper.toList(paymentService.getPayments());
    }

    @PostMapping("scheduling")
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentResponse createSchedulingPayment(@Valid @RequestBody PaymentRequest request) {
        var entity = paymentMapper.toEntity(request);
        var saved = paymentService.createSchedulingPayment(entity);
        return paymentMapper.toResponse(saved);
    }
}
