package com.andrezasecon.orange.configuration;

import com.andrezasecon.orange.domain.Cidade;
import com.andrezasecon.orange.domain.Endereco;
import com.andrezasecon.orange.domain.Estado;
import com.andrezasecon.orange.domain.Usuario;
import com.andrezasecon.orange.repositories.CidadeRepository;
import com.andrezasecon.orange.repositories.EnderecoRepository;
import com.andrezasecon.orange.repositories.EstadoRepository;
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
    private EstadoRepository estadoRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private UsuarioRepository userEepository;
    @Autowired
    private EnderecoRepository endRepository;

    @Override
    public void run(String... args) throws Exception {

        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "São Paulo");
        Estado est3 = new Estado(null, "Rio de janeiro");


        Cidade cid1 = new Cidade(null, "Uberlândia", est1);
        Cidade cid2 = new Cidade(null, "Osasco", est2);
        Cidade cid3 = new Cidade(null, "Petropolis", est3);
        Cidade cid4 = new Cidade(null, "Carapicuiba", est2);

        est1.getCidades().addAll(Arrays.asList(cid1));
        est2.getCidades().addAll(Arrays.asList(cid2, cid3));
        est3.getCidades().addAll(Arrays.asList(cid3, cid4));

        estadoRepository.saveAll(Arrays.asList(est1, est2, est3));
        cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3, cid4));


        Usuario user1 = new Usuario(null, "Andreza Secon", "andrezasecon@gmail.com", "24585452585", sdf.parse("05/06/1985"));
        Usuario user2 = new Usuario(null, "Leonardo Secon", "leonardo@gmail.com", "47852365988", sdf.parse("08/08/1982"));
        Usuario user3 = new Usuario(null, "Miguel Secon", "miguel@gmail.com", "2457856545", sdf.parse("16/02/2018"));


        Endereco end1 = new Endereco(null,  "Rua Flores", "300", "apto 203", "Jardim", "02452302", user1, cid1);
        Endereco end2 = new Endereco(null,  "Avenida Matos", "105", "Sala 800", "Centro", "05428320", user1, cid2);
        Endereco end3 = new Endereco(null,  "Rua das pedras", "1220", "viela", "Bela Vista", "06248524", user2, cid2);
        Endereco end4 = new Endereco(null,  "Rua matão", "3180", "casa fundos", "Arpoador", "06785421", user3, cid3);

        user1.getEnderecos().addAll(Arrays.asList(end1, end2, end2, end3));

        userEepository.saveAll(Arrays.asList(user1, user2, user3));
        endRepository.saveAll(Arrays.asList(end1, end2, end3, end4));

    }
}
