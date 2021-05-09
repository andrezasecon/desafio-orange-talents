package com.andrezasecon.orange.dto;

import com.andrezasecon.orange.domain.Endereco;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;


public class EnderecoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer idUser;



    public EnderecoDTO() {
    }


    public EnderecoDTO(Endereco objEndereco) {
        id = objEndereco.getId();
        logradouro = objEndereco.getLogradouro();
        numero = objEndereco.getNumero();
        complemento = objEndereco.getComplemento();
        bairro = objEndereco.getBairro();
        cep = objEndereco.getCep();
        cidade = objEndereco.getCidade();
        estado = objEndereco.getEstado();
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

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}