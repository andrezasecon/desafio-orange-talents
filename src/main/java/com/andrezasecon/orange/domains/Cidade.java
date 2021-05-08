package com.andrezasecon.orange.domains;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity // informa ao JPA que essa classe é uma tabela
public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id // informa ao JPA que o atributo id é o id na tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // gera automaticamente o id
    private Integer id;
    private String name;

    //Associação de muitos para 1 (Cidades possuem apenas um estado)
    @ManyToOne
    @JoinColumn(name = "estado_id") // chave estrangeira de estado na tabela cidade
    private Estado estado;

    // Construtor do objeto sem argumentos
    public Cidade(){

    }

    //construtor do objeto com argumentos
    public Cidade(Integer id, String name, Estado estado){
        this.id = id;
        this.name = name;
        this.estado = estado;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return Objects.equals(id, cidade.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
