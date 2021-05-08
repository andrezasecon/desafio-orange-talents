package com.andrezasecon.orange.domain;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Entity
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id // informa ao JPA que o atributo id é o id na tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // gera automaticamente o id
    private Integer id;
    private String name;
    private String email;
    private String cpf;
    private Date dataNiver;

    // Associação 1 para muitos (Um cliente possui 1 ou muitos endereços)
    @OneToMany(mappedBy = "usuario") // jpa foi mapeado na classe usuário
    private List<Endereco> enderecos = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(Integer id, String name, String email, String cpf, Date dataNiver) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.dataNiver = dataNiver;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNiver() {
        return dataNiver;
    }

    public void setDataNiver(Date dataNiver) {
        this.dataNiver = dataNiver;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
