package com.douglas.model;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "usuarios")
public class UsuarioModel {


    private Integer id;
    private Date dataCadastro;
    private String nome;
    private String rgCpfCnpj;    
    private BigDecimal receitaFixa;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "data_cadastro")
    @Temporal(TemporalType.DATE)
    public Date getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Column(name = "nome")
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "rg_cpf_cnpj")
    public String getRgCpfCnpj() {
        return rgCpfCnpj;
    }
    public void setRgCpfCnpj(String rgCpfCnpj) {
        this.rgCpfCnpj = rgCpfCnpj;
    }

    @Column(name = "receita_fixa")
    public BigDecimal getReceitaFixa() {
        return receitaFixa;
    }
    public void setReceitaFixa(BigDecimal receitaFixa) {
        this.receitaFixa = receitaFixa;
    }

}
