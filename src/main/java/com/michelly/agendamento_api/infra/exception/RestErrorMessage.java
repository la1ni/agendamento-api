package com.michelly.agendamento_api.infra.exception;

import org.springframework.http.HttpStatus;

public class RestErrorMessage {

    private HttpStatus status;
    private String message;

    public RestErrorMessage(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
