package br.com.desafio.domain.exception;

public class NoApplicableTaxException extends RuntimeException {

    public NoApplicableTaxException(String message) {
        super(message);
    }

}
