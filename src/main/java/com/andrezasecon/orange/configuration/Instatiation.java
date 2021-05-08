package com.andrezasecon.orange.configuration;

import com.andrezasecon.orange.domains.Cidade;
import com.andrezasecon.orange.domains.Estado;
import com.andrezasecon.orange.repositories.CidadeRepository;
import com.andrezasecon.orange.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instatiation implements CommandLineRunner {

    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private CidadeRepository cidadeRepository;

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

    }
}
