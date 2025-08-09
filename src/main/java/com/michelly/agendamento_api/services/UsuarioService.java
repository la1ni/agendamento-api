package com.michelly.agendamento_api.services;

import com.michelly.agendamento_api.domain.model.Usuario;
import com.michelly.agendamento_api.dtos.in.RequestCriarUsuarioDto;
import com.michelly.agendamento_api.dtos.out.ResponseDadosUsuarioDto;
import com.michelly.agendamento_api.dtos.out.ResponserUsuarioCriadoDto;
import com.michelly.agendamento_api.infra.exception.NotFoundException;
import com.michelly.agendamento_api.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponserUsuarioCriadoDto criarUsuario(RequestCriarUsuarioDto requestCriarUsuarioDto) {
        Usuario usuario = new Usuario(requestCriarUsuarioDto);
        this.usuarioRepository.save(usuario);
        return new ResponserUsuarioCriadoDto(usuario.getId());
    }

    // Implementar exception
    public ResponseDadosUsuarioDto buscaUsuario(UUID id) throws Exception {
        Optional<Usuario> usuario = Optional.of(this.usuarioRepository.getById(id));
        if (usuario.isPresent()) {
            return new ResponseDadosUsuarioDto(usuario.get().getNome(), usuario.get().getEmail(), usuario.get().getTelefone());
        }
        else throw new NotFoundException("Usuario", id);
    }

    public List<ResponseDadosUsuarioDto> buscaUsuarios() {
        List<Usuario> usuarios = this.usuarioRepository.findAll();
        return usuarios.stream().map(usuario -> new ResponseDadosUsuarioDto(usuario.getNome(), usuario.getEmail(), usuario.getTelefone())).toList();
    }
}
