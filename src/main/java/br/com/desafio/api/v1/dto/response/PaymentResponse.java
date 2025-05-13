package br.com.desafio.api.v1.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentResponse {

    private UUID id;
    private String originAgency;
    private String originAccount;
    private String destinationAgency;
    private String destinationAccount;
    private BigDecimal transferAmount;
    private BigDecimal tax;
    private LocalDate transferDate;
    private LocalDate schedulingDate;

}
