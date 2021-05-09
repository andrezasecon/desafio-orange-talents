package com.andrezasecon.orange.domain;

import com.andrezasecon.orange.dto.EnderecoDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id // informa ao JPA que o atributo id é o id na tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // gera automaticamente o id
    private Integer id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    private String estado;
    private String cidade;

    // Associação muitos para muitos
    @ManyToMany(mappedBy = "enderecos")
    Set<Usuario> usuario;

    public Endereco() {
    }

    public Endereco(Integer id, String logradouro, String numero, String complemento, String bairro, String cep, String cidade, String estado) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;

    }

    public Endereco(EnderecoDTO enderecoDTO) {
        this.logradouro = enderecoDTO.getLogradouro();
        this.numero = enderecoDTO.getNumero();
        this.complemento = enderecoDTO.getComplemento();
        this.bairro = enderecoDTO.getBairro();
        this.cep = enderecoDTO.getCep();
        this.cidade = enderecoDTO.getCidade();
        this.estado = enderecoDTO.getEstado();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Set<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(Set<Usuario> usuario) {
        this.usuario = usuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(id, endereco.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
