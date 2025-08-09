package com.michelly.agendamento_api.controllers;

import com.michelly.agendamento_api.dtos.in.RequestCriarUsuarioDto;
import com.michelly.agendamento_api.dtos.out.ResponseDadosUsuarioDto;
import com.michelly.agendamento_api.dtos.out.ResponserUsuarioCriadoDto;
import com.michelly.agendamento_api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<ResponserUsuarioCriadoDto> criarUsuario(@RequestBody RequestCriarUsuarioDto requestCriarUsuarioDto) {
        return ResponseEntity.status(201).body(usuarioService.criarUsuario(requestCriarUsuarioDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDadosUsuarioDto> buscarUsuario(@PathVariable UUID id) throws Exception {
        return  ResponseEntity.ok().body(usuarioService.buscaUsuario(id));
    }

    @GetMapping
    public ResponseEntity<List<ResponseDadosUsuarioDto>> buscarTodosUsuarios() throws Exception {
        return ResponseEntity.ok().body(usuarioService.buscaUsuarios());
    }

}
