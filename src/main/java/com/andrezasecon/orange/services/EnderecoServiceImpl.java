package com.andrezasecon.orange.services;

import com.andrezasecon.orange.domain.Endereco;
import com.andrezasecon.orange.domain.Usuario;
import com.andrezasecon.orange.dto.UsuarioDTO;
import com.andrezasecon.orange.repositories.EnderecoRepository;
import com.andrezasecon.orange.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoServiceImpl implements EnderecoService{

    @Autowired
    private EnderecoRepository endRepository;


    @Override
    public Endereco inserirEndereco(Endereco endereco) {
        return endRepository.save(endereco);
    }
}

