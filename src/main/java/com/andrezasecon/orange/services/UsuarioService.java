package com.andrezasecon.orange.services;

import com.andrezasecon.orange.domain.Usuario;
import com.andrezasecon.orange.dto.UsuarioDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UsuarioService {

    List<Usuario> buscarTodos();
    Optional<Usuario> buscarPorId(Integer id);
    Usuario inserirUsuario(Usuario usuario);
    Usuario fromDTO(UsuarioDTO objDTO);
    void deletarUsuario(Integer id);
}
