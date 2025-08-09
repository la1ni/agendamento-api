package com.michelly.agendamento_api.infra.exception;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String nomeEntidade, UUID uuid) {
        super(String.format("%s com o id %s não encontrado", nomeEntidade, uuid.toString()));
    }
}
