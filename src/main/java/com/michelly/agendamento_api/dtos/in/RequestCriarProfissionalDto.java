package com.michelly.agendamento_api.dtos.in;

import java.util.List;
import java.util.UUID;

public record RequestCriarProfissionalDto(String nome, String email, String telefone, List<UUID> servicos) {
}
