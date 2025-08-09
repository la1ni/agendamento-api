package com.michelly.agendamento_api.dtos.out;

import java.io.Serializable;
import java.util.UUID;

public record ResponseNomeIdServicoDto(UUID id,String nome) {
}
