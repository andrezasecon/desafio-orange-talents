package com.andrezasecon.orange.repositories;

import com.andrezasecon.orange.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
}
