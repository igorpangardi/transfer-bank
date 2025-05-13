package br.com.desafio.api.v1.dto.request;

import static br.com.desafio.api.v1.constant.PaymentRequestConstants.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequest {

    @Pattern(regexp = ORIGIN_AGENCY_REGEX, message = ORIGIN_AGENCY_MESSAGE_LENGTH)
    @NotNull(message = ORIGIN_AGENCY_MESSAGE_MANDATORY)
    private String originAgency;

    @Pattern(regexp = ORIGIN_ACCOUNT_REGEX, message = ORIGIN_ACCOUNT_MESSAGE_LENGTH)
    @NotNull(message = ORIGIN_ACCOUNT_MESSAGE_MANDATORY)
    private String originAccount;

    @Pattern(regexp = DESTINATION_AGENCY_REGEX, message = DESTINATION_AGENCY_MESSAGE_LENGTH)
    @NotNull(message = DESTINATION_AGENCY_MESSAGE_MANDATORY)
    private String destinationAgency;

    @Pattern(regexp = DESTINATION_ACCOUNT_REGEX, message = DESTINATION_ACCOUNT_MESSAGE_LENGTH)
    @NotNull(message = DESTINATION_ACCOUNT_MESSAGE_MANDATORY)
    private String destinationAccount;

    @NotNull(message = TRANSFER_AMOUNT_MESSAGE_MANDATORY)
    @DecimalMin(value = TRANSFER_AMOUNT_MIN_VALUE, inclusive = true, message = TRANSFER_AMOUNT_MESSAGE_MIN)
    private BigDecimal transferAmount;

    @NotNull(message = TRANSFER_DATE_MESSAGE_MANDATORY)
    @FutureOrPresent(message = TRANSFER_DATE_MESSAGE_FUTURE_OR_PRESENT)
    private LocalDate transferDate;

}