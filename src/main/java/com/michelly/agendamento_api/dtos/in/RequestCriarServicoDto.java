package com.michelly.agendamento_api.dtos.in;

import java.math.BigDecimal;
import java.time.Duration;

public record RequestCriarServicoDto(String nome, BigDecimal valor, String duracao) {
}
