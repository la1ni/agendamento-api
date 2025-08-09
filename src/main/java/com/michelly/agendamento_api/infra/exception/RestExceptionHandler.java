package com.michelly.agendamento_api.infra.exception;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ApiResponse(responseCode ="404", description = "Recurso não encontrado")
    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<RestErrorMessage> NotFoundExceptionHandler(NotFoundException e) {
        RestErrorMessage response = new RestErrorMessage(HttpStatus.NOT_FOUND, e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
