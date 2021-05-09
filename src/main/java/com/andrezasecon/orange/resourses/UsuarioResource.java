package com.andrezasecon.orange.resourses;


import com.andrezasecon.orange.domain.Usuario;
import com.andrezasecon.orange.dto.UsuarioDTO;
import com.andrezasecon.orange.services.UsuarioService;
import com.andrezasecon.orange.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity <List<UsuarioDTO>> buscarTodos() {
        List<Usuario> list = usuarioService.buscarTodos();
        List<UsuarioDTO> listDTO = list.stream().map(UsuarioDTO::new).collect(Collectors.toList());
        if (!list.isEmpty()) {
            return ResponseEntity.ok().body(listDTO);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Integer id) {
        Optional<Usuario> user = usuarioService.buscarPorId(id);
        if (user.isPresent()) {
            return ResponseEntity.ok().body(new UsuarioDTO(user.get()));
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> inserirUsuario(@RequestBody UsuarioDTO objDTO){
        Usuario obj = usuarioService.fromDTO(objDTO);
        obj = usuarioService.inserirUsuario(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{/id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Integer id){
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }


}
