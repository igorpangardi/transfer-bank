package br.com.desafio.api.v1.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PaymentRequestConstants {

    public static final String ORIGIN_AGENCY_REGEX = "^[0-9]{4}$";
    public static final String ORIGIN_AGENCY_MESSAGE_LENGTH = "Origin agency must contain exactly 4 digits";
    public static final String ORIGIN_AGENCY_MESSAGE_MANDATORY = "Origin agency is mandatory";
    public static final String ORIGIN_ACCOUNT_REGEX = "^[0-9]{6}$";
    public static final String ORIGIN_ACCOUNT_MESSAGE_LENGTH = "Origin account must contain exactly 6 digits";
    public static final String ORIGIN_ACCOUNT_MESSAGE_MANDATORY = "Origin account is mandatory";
    public static final String DESTINATION_AGENCY_REGEX = "^[0-9]{4}$";
    public static final String DESTINATION_AGENCY_MESSAGE_LENGTH = "Destination agency must contain exactly 4 digits";
    public static final String DESTINATION_AGENCY_MESSAGE_MANDATORY = "Destination agency is mandatory";
    public static final String DESTINATION_ACCOUNT_REGEX = "^[0-9]{6}$";
    public static final String DESTINATION_ACCOUNT_MESSAGE_LENGTH = "Destination account must contain exactly 6 digits";
    public static final String DESTINATION_ACCOUNT_MESSAGE_MANDATORY = "Destination account is mandatory";
    public static final String TRANSFER_AMOUNT_MIN_VALUE = "0.01";
    public static final String TRANSFER_AMOUNT_MESSAGE_MANDATORY = "Transfer amount is mandatory";
    public static final String TRANSFER_AMOUNT_MESSAGE_MIN = "Transfer amount must be greater than zero";
    public static final String TRANSFER_DATE_MESSAGE_MANDATORY = "Transfer date is mandatory";
    public static final String TRANSFER_DATE_MESSAGE_FUTURE_OR_PRESENT = "Transfer date must be today or a future date";

}