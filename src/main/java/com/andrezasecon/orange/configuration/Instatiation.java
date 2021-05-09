package com.andrezasecon.orange.configuration;

import com.andrezasecon.orange.domain.Endereco;
import com.andrezasecon.orange.domain.Usuario;
import com.andrezasecon.orange.repositories.EnderecoRepository;
import com.andrezasecon.orange.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@Configuration
public class Instatiation implements CommandLineRunner {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    @Autowired
    private UsuarioRepository userEepository;
    @Autowired
    private EnderecoRepository endRepository;

    @Override
    public void run(String... args) throws Exception {


//
//        Endereco end1 = new Endereco(null,  "Rua Flores", "300", "apto 203", "Jardim", "02452302", "Osasco", "São Paulo");
//        Endereco end2 = new Endereco(null,  "Avenida Matos", "105", "Sala 800", "Centro", "05428320", "Osasco", "São Paulo");
//        Endereco end3 = new Endereco(null,  "Rua das pedras", "1220", "viela", "Bela Vista", "06248524", "Osasco", "São Paulo");
//        Endereco end4 = new Endereco(null,  "Rua matão", "3180", "casa fundos", "Arpoador", "06785421", "Osasco", "São Paulo");
//
//
//        endRepository.saveAll(Arrays.asList(end1, end2, end3, end4));
//
//        Usuario user1 = new Usuario(null, "Andreza Secon", "andrezasecon@gmail.com", "24585452585", sdf.parse("05/06/1985"));
//        Usuario user2 = new Usuario(null, "Leonardo Secon", "leonardo@gmail.com", "47852365988", sdf.parse("08/08/1982"));
//        Usuario user3 = new Usuario(null, "Miguel Secon", "miguel@gmail.com", "2457856545", sdf.parse("16/02/2018"));
//
//
//
//        user1.getEnderecos().addAll(Arrays.asList(end1, end2));
//        user2.getEnderecos().addAll(Arrays.asList(end2));
//        user3.getEnderecos().addAll(Arrays.asList(end3));
//
//
//        userEepository.saveAll(Arrays.asList(user1, user2, user3));

    }
}
