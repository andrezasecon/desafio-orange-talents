package com.andrezasecon.orange.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Entity
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id // informa ao JPA que o atributo id é o id na tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // gera automaticamente o id
    private Integer id;


    private String nome;

    @Column(unique=true)
    private String email;

    @Column(unique=true)
    private String cpf;

    private Date dataNiver;

    // Associação 1 para muitos (Um cliente possui 1 ou muitos endereços)
    //@OneToMany(mappedBy = "usuario") // jpa foi mapeado na classe

    @ManyToMany
    @JoinTable(name = "tb_usuario_endereco",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "endereco_id"))
    private List<Endereco> enderecos;

    public Usuario() {
    }

    public Usuario(Integer id, String nome, String email, String cpf, Date dataNiver) {
        this.id = id;
        this.nome = nome;
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

    public String getnome() {
        return nome;
    }

    public void setnome(String nome) {
        this.nome = nome;
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
