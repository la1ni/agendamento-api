package com.michelly.agendamento_api.services;

import com.michelly.agendamento_api.domain.model.Servico;
import com.michelly.agendamento_api.dtos.in.RequestCriarServicoDto;
import com.michelly.agendamento_api.dtos.out.ResponseDadosServicoDto;
import com.michelly.agendamento_api.dtos.out.ResponseNomeIdServicoDto;
import com.michelly.agendamento_api.infra.exception.NotFoundException;
import com.michelly.agendamento_api.repositories.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public ResponseDadosServicoDto criarServico(RequestCriarServicoDto requestCriarServicoDto) {
        Servico servico = new Servico(requestCriarServicoDto.nome(), requestCriarServicoDto.valor(), requestCriarServicoDto.duracao());
        this.servicoRepository.save(servico);
        Optional<Servico> servicoOptional = this.servicoRepository.findById(servico.getId());
        if (servicoOptional.isPresent()) {
            return new ResponseDadosServicoDto(servicoOptional.get().getId(), servicoOptional.get().getNome(), servicoOptional.get().getValor(), servicoOptional.get().getDuracao());
        } else {
            throw new NotFoundException("Servico", servico.getId());
        }
    }

    public List<ResponseNomeIdServicoDto> buscarIdNomeServicos() {
        java.util.List<Servico> listaServicos = this.servicoRepository.findAll();
        return listaServicos.stream().map(servico -> new ResponseNomeIdServicoDto(servico.getId(), servico.getNome())).toList();
    }

    public ResponseDadosServicoDto buscarServicoPorId(UUID id) {
        Servico servico = this.servicoRepository.findById(id).orElseThrow(() -> new NotFoundException("Servico", id));
        return new ResponseDadosServicoDto (servico.getId(), servico.getNome(), servico.getValor(), servico.getDuracao());
    }
}
