package br.com.desafio.api.v1.handler;

import java.util.List;
import java.util.stream.Collectors;

import br.com.desafio.exception.NoApplicableTaxException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.lang.NonNull;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String NO_APPLICABLE_TAX_TITLE = "No Applicable Tax";
    private static final String NO_APPLICABLE_TAX_MESSAGE = "Check the transfer date and amount.";
    private static final String VALIDATION_ERROR_TITLE = "Validation Error";
    private static final String VALIDATION_ERROR_MESSAGE = "One or more fields have validation errors";
    private static final String MALFORMED_JSON_TITLE = "Malformed JSON request";
    private static final String MALFORMED_JSON_USER_MESSAGE = "Request body contains invalid or incorrectly formatted fields";
    private static final String MALFORMED_JSON_SUGGESTION = "Check that all fields are properly typed and formatted.";

    @ExceptionHandler(NoApplicableTaxException.class)
    public ResponseEntity<Object> handleNoApplicableTaxException(NoApplicableTaxException ex, WebRequest request) {
        String path = ((ServletWebRequest) request).getRequest().getRequestURI();
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST.value(), NO_APPLICABLE_TAX_TITLE, ex.getMessage(), List.of(NO_APPLICABLE_TAX_MESSAGE), path);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }

    @NonNull
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            @NonNull MethodArgumentNotValidException ex,
            @NonNull HttpHeaders headers,
            @NonNull HttpStatus status,
            @NonNull WebRequest request) {

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());

        String path = ((ServletWebRequest) request).getRequest().getRequestURI();
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST.value(), VALIDATION_ERROR_TITLE,
                VALIDATION_ERROR_MESSAGE, errors, path);

        return super.handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @Override
    @NonNull
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            @NonNull HttpMessageNotReadableException ex,
            @NonNull HttpHeaders headers,
            @NonNull HttpStatus status,
            @NonNull WebRequest request) {

        String path = ((ServletWebRequest) request).getRequest().getRequestURI();

        ApiError apiError = new ApiError(
                HttpStatus.BAD_REQUEST.value(),
                MALFORMED_JSON_TITLE,
                MALFORMED_JSON_USER_MESSAGE,
                List.of(MALFORMED_JSON_SUGGESTION),
                path);

        return super.handleExceptionInternal(ex, apiError, headers, status, request);
    }

}