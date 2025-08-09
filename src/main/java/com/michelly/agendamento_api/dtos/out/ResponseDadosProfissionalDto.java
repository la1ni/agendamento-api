package com.michelly.agendamento_api.dtos.out;

import java.util.UUID;

public record ResponseDadosProfissionalDto(UUID id, String nome, String email, String telefone) {
}
