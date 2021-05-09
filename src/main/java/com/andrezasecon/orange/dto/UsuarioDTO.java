package com.andrezasecon.orange.dto;

import com.andrezasecon.orange.domain.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String email;
    private String cpf;
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataNiver;
    private List<EnderecoDTO> listEnderecosDTO;

    public UsuarioDTO() {
    }


    public UsuarioDTO(Usuario userObj) {
        id = userObj.getId();
        nome = userObj.getnome();
        email = userObj.getEmail();
        cpf = userObj.getCpf();
        dataNiver = userObj.getDataNiver();
        listEnderecosDTO = userObj.getEnderecos().stream().map(EnderecoDTO::new).collect(Collectors.toList());
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

    public List<EnderecoDTO> getListEnderecosDTO() {
        return listEnderecosDTO;
    }

    public void setListEnderecosDTO(List<EnderecoDTO> listEnderecosDTO) {
        this.listEnderecosDTO = listEnderecosDTO;
    }
}
