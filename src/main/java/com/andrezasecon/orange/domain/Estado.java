package com.andrezasecon.orange.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity // informa ao JPA que essa classe é uma tabela
public class Estado implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id // informa ao JPA que o atributo id é o id na tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // gera automaticamente o id
    private Integer id;
    private String name;

    //Associação de 1 para muitos (Um Estado possui muitas cidades)
    // A lista deve ser instanciada
    @OneToMany(mappedBy = "estado") // atributo de estado que mapeou a cidade
    private List<Cidade> cidades = new ArrayList<>();

    public Estado() {
    }

    public Estado(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return Objects.equals(id, estado.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
