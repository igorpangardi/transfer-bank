package br.com.desafio.api.v1.handler;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiError {

    private String title;
    private int status;
    private String detail;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private OffsetDateTime timestamp;

    private List<String> errors;
    private String path;

    public ApiError(int status, String title, String detail, String path) {
        this.timestamp = OffsetDateTime.now(ZoneOffset.UTC);
        this.status = status;
        this.title = title;
        this.detail = detail;
        this.path = path;
    }

    public ApiError(int status, String title, String detail, List<String> errors, String path) {
        this(status, title, detail, path);
        this.errors = errors;
    }
}
