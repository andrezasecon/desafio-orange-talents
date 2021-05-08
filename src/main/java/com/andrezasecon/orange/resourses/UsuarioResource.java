package com.andrezasecon.orange.resourses;


import com.andrezasecon.orange.domain.Usuario;
import com.andrezasecon.orange.repositories.EnderecoRepository;
import com.andrezasecon.orange.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value="/usuario")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findUserById(@PathVariable Integer id){
        Usuario obj = usuarioService.findUserById(id);
        return ResponseEntity.ok().body(obj);
    }
}
