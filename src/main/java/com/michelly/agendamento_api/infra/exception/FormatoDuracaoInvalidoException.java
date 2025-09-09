package com.michelly.agendamento_api.infra.exception;

import java.util.UUID;

public class FormatoDuracaoInvalidoException extends RuntimeException {

    public FormatoDuracaoInvalidoException(String mensagem) {
        super("Formato de duração inválido. O formato correto é HH:mm");
    }
}
