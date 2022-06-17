/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.consumer.exception;

import java.util.Objects;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Luan Pedro Tomiozzo
 */
public class RestResponseDetailsBuilder extends RestResponseDetails {

    private Integer status;
    private String error;
    private String details;
    private String path;

    public RestResponseDetailsBuilder status(int status) {
        this.status = status;
        return this;
    }

    public RestResponseDetailsBuilder status(HttpStatus status) {
        this.status = status.value();
        return this;
    }

    public RestResponseDetailsBuilder erro(String error) {
        this.error = error;
        return this;
    }

    public RestResponseDetailsBuilder exception(ResponseStatusException exception) {
        HttpStatus status = exception.getStatus();
        this.status = status.value();

        if (!Objects.requireNonNull(exception.getReason()).isEmpty()) {
            this.details = exception.getReason();
        }

        if (status.isError()) {
            this.error = status.getReasonPhrase();
        }
        return this;
    }

    public RestResponseDetailsBuilder mensagem(String message) {
        this.details = message;
        return this;
    }

    public RestResponseDetailsBuilder caminho(String path) {
        this.path = path;
        return this;
    }

    public RestResponseDetails build() {
        RestResponseDetails response = new RestResponseDetails();
        response.setStatus(status);
        response.setError(error);
        response.setDetails(details);
        response.setPath(path);
        return response;
    }

    public ResponseEntity<RestResponseDetails> entity() {
        return ResponseEntity.status(status).headers(HttpHeaders.EMPTY).body(build());
    }

    public String json() {
        return build().toJson();
    }
}
