package com.douglas.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "receitas_variaveis")
public class VariableIncomeModel {

    private Integer id;
    private UserModel idUsuario;
    private BigDecimal valor;
    private String descricao;
    private LocalDate dataEntrada;

    public VariableIncomeModel() {
    }

    public VariableIncomeModel(Integer id, UserModel idUsuario, BigDecimal valor, String descricao,
            LocalDate dataEntrada) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.valor = valor;
        this.descricao = descricao;
        this.dataEntrada = dataEntrada;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    public UserModel getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UserModel idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Column(name = "valor")
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Column(name = "descricao")
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Column(name = "data_entrada")
    @Temporal(TemporalType.DATE)
    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

}
