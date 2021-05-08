package com.andrezasecon.orange.services;

import com.andrezasecon.orange.domain.Usuario;
import com.andrezasecon.orange.repositories.EnderecoRepository;
import com.andrezasecon.orange.repositories.UsuarioRepository;
import javassist.tools.rmi.ObjectNotFoundException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    // Implementação do método para buscar cliente por ID
    public Usuario findUserById(Integer id){
        Optional<Usuario> obj = usuarioRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(String.valueOf(id)));
    }
}
