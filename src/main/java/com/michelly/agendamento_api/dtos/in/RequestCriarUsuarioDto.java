package com.michelly.agendamento_api.dtos.in;

public record RequestCriarUsuarioDto(String nome, String email, String telefone, String cpf) {
}
