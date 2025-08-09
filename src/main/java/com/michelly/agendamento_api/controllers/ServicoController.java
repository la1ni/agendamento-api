package com.michelly.agendamento_api.controllers;

import com.michelly.agendamento_api.dtos.in.RequestCriarServicoDto;
import com.michelly.agendamento_api.dtos.out.ResponseDadosServicoDto;
import com.michelly.agendamento_api.dtos.out.ResponseNomeIdServicoDto;
import com.michelly.agendamento_api.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @PostMapping
    public ResponseEntity<ResponseDadosServicoDto> criarServico(@RequestBody RequestCriarServicoDto requestCriarServicoDto) {
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(this.servicoService.criarServico(requestCriarServicoDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDadosServicoDto> buscarServico(@PathVariable UUID id) {
        return ResponseEntity.ok(this.servicoService.buscarServicoPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<ResponseNomeIdServicoDto>> buscarNomeServicos() {
        return ResponseEntity.ok(this.servicoService.buscarIdNomeServicos());
    }

}
