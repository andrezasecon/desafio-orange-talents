package com.andrezasecon.orange.services;

import com.andrezasecon.orange.domain.Endereco;
import org.springframework.stereotype.Service;

@Service
public interface EnderecoService  {

    Endereco inserirEndereco(Endereco endereco);

}
