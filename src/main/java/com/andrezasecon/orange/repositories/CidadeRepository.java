package com.andrezasecon.orange.repositories;

import com.andrezasecon.orange.domains.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}