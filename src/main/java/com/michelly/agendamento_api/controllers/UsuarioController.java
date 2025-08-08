package com.michelly.agendamento_api.controllers;

import com.michelly.agendamento_api.dtos.in.CriarUsuarioDto;
import com.michelly.agendamento_api.dtos.out.DadosUsuarioDto;
import com.michelly.agendamento_api.dtos.out.UsuarioCriadoDto;
import com.michelly.agendamento_api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioCriadoDto> criarUsuario(@RequestBody CriarUsuarioDto criarUsuarioDto) {
        return ResponseEntity.ok().body(usuarioService.criarUsuario(criarUsuarioDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosUsuarioDto> buscarUsuario(@PathVariable UUID id) throws Exception {
        return  ResponseEntity.ok().body(usuarioService.buscaUsuario(id));
    }

}
