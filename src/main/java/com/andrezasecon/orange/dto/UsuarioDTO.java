package com.andrezasecon.orange.dto;

import com.andrezasecon.orange.domain.Usuario;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;


public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotNull(message = "Digite um nome")
    @NotEmpty(message = "Campo nome não pode ser vazio")
    @Size(min = 3, max = 30, message = "O nome deve ter entre 3 e 30 caracteres")
    private String nome;

    @NotNull(message = "Digite um email")
    @NotEmpty(message = "Campo email não pode ser vazio")
    @Email(message = "email inválido")
    private String email;

    @NotNull(message = "Digite um CPF")
    @NotEmpty(message = "Campo CPF não pode ser vazio")
    @CPF(message = "CPF invalido")
    private String cpf;


    @NotEmpty(message = "Digite uma data")
    @Pattern(regexp = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$",
            message = "A data de nascimento deve ser no formato dd/mm/aaaa")
    public String dataNasc = null;

    private List<EnderecoDTO> listEnderecosDTO;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario userObj) {
        id = userObj.getId();
        nome = userObj.getnome();
        email = userObj.getEmail();
        cpf = userObj.getCpf();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dataNasc = dateFormat.format(userObj.getDataNiver());
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

    public List<EnderecoDTO> getListEnderecosDTO() {
        return listEnderecosDTO;
    }

    public void setListEnderecosDTO(List<EnderecoDTO> listEnderecosDTO) {
        this.listEnderecosDTO = listEnderecosDTO;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }
}
