package com.andrezasecon.orange.services;

import com.andrezasecon.orange.domain.Usuario;
import com.andrezasecon.orange.dto.UsuarioDTO;
import com.andrezasecon.orange.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public List<Usuario> buscarTodos() {

        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> buscarPorId(Integer id) {

        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario inserirUsuario(Usuario usuario) {

        return usuarioRepository.save(usuario);
    }

    @Override
    public void deletarUsuario(Integer id) {
        usuarioRepository.deleteById(id);

    }

    public Usuario fromDTO(UsuarioDTO objDTO){
        return new Usuario(objDTO.getId(), objDTO.getnome(), objDTO.getEmail(), objDTO.getCpf(), objDTO.getDataNiver());
    }

}
