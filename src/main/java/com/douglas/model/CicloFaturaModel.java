package com.douglas.model;

import java.math.BigDecimal;

import com.douglas.enums.BancoType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ciclos_faturas")
public class CicloFaturaModel {

    private Integer id;
    private UsuarioModel usuario;
    private Integer diaAbertura;
    private Integer diaFechamento;
    private Integer diaVencimento;
    private BigDecimal valorCicloFatura;
    private BancoType banco;

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
    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel idUsuario) {
        this.usuario = idUsuario;
    }

    @Column(name = "dia_abertura")
    public Integer getDiaAbertura() {
        return diaAbertura;
    }

    public void setDiaAbertura(Integer diaAbertura) {
        this.diaAbertura = diaAbertura;
    }

    @Column(name = "dia_fechamento")
    public Integer getDiaFechamento() {
        return diaFechamento;
    }

    public void setDiaFechamento(Integer diaFechamento) {
        this.diaFechamento = diaFechamento;
    }

    @Column(name = "dia_vencimento")
    public Integer getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(Integer diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    @Column(name = "valor_ciclo_fatura")
    public BigDecimal getValorCicloFatura() {
        return valorCicloFatura;
    }

    public void setValorCicloFatura(BigDecimal valorCicloFatura) {
        this.valorCicloFatura = valorCicloFatura;
    }

    @Column(name = "banco")
    @Enumerated(EnumType.ORDINAL)
    public BancoType getBanco() {
        return banco;
    }

    public void setBanco(BancoType banco) {
        this.banco = banco;
    }

}
