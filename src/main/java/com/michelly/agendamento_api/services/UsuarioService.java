package com.michelly.agendamento_api.services;

import com.michelly.agendamento_api.domain.model.Usuario;
import com.michelly.agendamento_api.dtos.in.CriarUsuarioDto;
import com.michelly.agendamento_api.dtos.out.DadosUsuarioDto;
import com.michelly.agendamento_api.dtos.out.UsuarioCriadoDto;
import com.michelly.agendamento_api.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioCriadoDto criarUsuario(CriarUsuarioDto criarUsuarioDto) {
        Usuario usuario = new Usuario(criarUsuarioDto);
        this.usuarioRepository.save(usuario);
        return new UsuarioCriadoDto(usuario.getId());
    }

    // Implementar exception
    public DadosUsuarioDto buscaUsuario(UUID id) throws Exception {
        Optional<Usuario> usuario = Optional.of(this.usuarioRepository.getById(id));
        if (usuario.isPresent()) {
            return new DadosUsuarioDto(usuario.get().getNome(), usuario.get().getEmail(), usuario.get().getTelefone());
        }
        else throw new Exception();
    }
}
