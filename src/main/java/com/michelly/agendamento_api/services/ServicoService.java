package com.michelly.agendamento_api.services;

import com.michelly.agendamento_api.domain.model.Servico;
import com.michelly.agendamento_api.dtos.in.RequestCriarServicoDto;
import com.michelly.agendamento_api.dtos.out.ResponseDadosServicoDto;
import com.michelly.agendamento_api.dtos.out.ResponseNomeIdServicoDto;
import com.michelly.agendamento_api.infra.exception.FormatoDuracaoInvalidoException;
import com.michelly.agendamento_api.infra.exception.NotFoundException;
import com.michelly.agendamento_api.repositories.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public ResponseDadosServicoDto criarServico(RequestCriarServicoDto requestCriarServicoDto) {
        Servico servico = new Servico(requestCriarServicoDto.nome(), requestCriarServicoDto.valor(), converteStringDuration(requestCriarServicoDto.duracao()));
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

    private Duration converteStringDuration(String durationString) {
        if (durationString != null && durationString.contains(":")) {
            String[] stringDurationSplit = durationString.split(":");
            if (stringDurationSplit.length == 2) {
                for (String s : stringDurationSplit) {
                    try {
                        Integer.parseInt(s);
                    } catch (NumberFormatException e) {
                        throw new FormatoDuracaoInvalidoException("Formato inválido");
                    }
                }
                int horas = Integer.parseInt(stringDurationSplit[0]);
                int minutos = Integer.parseInt(stringDurationSplit[1]);
                Duration duracao = Duration.ofHours(horas).plus(Duration.ofMinutes(minutos));
                return duracao;
            }
        }
        throw new FormatoDuracaoInvalidoException("Formato de duracao Invalido");
    }
}
