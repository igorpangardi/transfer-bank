package br.com.desafio.api.v1.mapper;

import java.util.List;

import br.com.desafio.api.v1.dto.request.PaymentRequest;
import br.com.desafio.api.v1.dto.response.PaymentResponse;
import br.com.desafio.domain.model.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    Payment toEntity(PaymentRequest request);

    PaymentResponse toResponse(Payment payment);

    List<PaymentResponse> toList(List<Payment> payments);
}
