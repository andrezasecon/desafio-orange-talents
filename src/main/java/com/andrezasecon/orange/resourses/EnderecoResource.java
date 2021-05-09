package com.andrezasecon.orange.resourses;


import com.andrezasecon.orange.domain.Endereco;
import com.andrezasecon.orange.domain.Usuario;
import com.andrezasecon.orange.dto.EnderecoDTO;
import com.andrezasecon.orange.services.EnderecoService;
import com.andrezasecon.orange.services.UsuarioService;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

@RestController
@RequestMapping(value="/enderecos")
public class EnderecoResource {

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Void> inserirEndereco(@RequestBody EnderecoDTO endDTO){
        Optional<Usuario> user = usuarioService.buscarPorId(endDTO.getIdUser());
      if(user.isPresent()){
          Endereco endereco = new Endereco(endDTO);
          Usuario _user = user.get();
          _user.getEnderecos().add(endereco);
          endereco.setUsuario(new HashSet(Arrays.asList(_user)));
          enderecoService.inserirEndereco(endereco);

          return ResponseEntity.ok().build();
      }
        return ResponseEntity.badRequest().build();
    }

}
