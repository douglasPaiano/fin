package com.douglas.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contas")
public class ContaModel {

    private Integer id;
    private CicloFaturaModel idCiclo;
    private UsuarioModel idUsuario;
    private BigDecimal receitaTotalMes;
    private BigDecimal receitaFixa;
    private BigDecimal receitaVariavel;
    private BigDecimal gastoTotal;
    private BigDecimal gastoProprio;
    private BigDecimal gastoTerceiros;
    private BigDecimal gastoFixo;
    private BigDecimal gastoVariavel;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JoinColumn(name = "id_ciclo", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    public CicloFaturaModel getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(CicloFaturaModel idCiclo) {
        this.idCiclo = idCiclo;
    }

    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    public UsuarioModel getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UsuarioModel idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Column(name = "receita_total_mes")
    public BigDecimal getReceitaTotalMes() {
        return receitaTotalMes;
    }

    public void setReceitaTotalMes(BigDecimal receitaTotalMes) {
        this.receitaTotalMes = receitaTotalMes;
    }

    @Column(name = "receita_fixa")
    public BigDecimal getReceitaFixa() {
        return receitaFixa;
    }

    public void setReceitaFixa(BigDecimal receitaFixa) {
        this.receitaFixa = receitaFixa;
    }

    @Column(name = "receita_variavel")
    public BigDecimal getReceitaVariavel() {
        return receitaVariavel;
    }

    public void setReceitaVariavel(BigDecimal receitaVariavel) {
        this.receitaVariavel = receitaVariavel;
    }

    @Column(name = "gastos_totais")
    public BigDecimal getGastoTotal() {
        return gastoTotal;
    }

    public void setGastoTotal(BigDecimal gastoTotal) {
        this.gastoTotal = gastoTotal;
    }

    @Column(name = "gasto_proprio")
    public BigDecimal getGastoProprio() {
        return gastoProprio;
    }

    public void setGastoProprio(BigDecimal gastoProprio) {
        this.gastoProprio = gastoProprio;
    }

    @Column(name = "gasto_terceiros")
    public BigDecimal getGastoTerceiros() {
        return gastoTerceiros;
    }

    public void setGastoTerceiros(BigDecimal gastoTerceiros) {
        this.gastoTerceiros = gastoTerceiros;
    }

    @Column(name = "gastos_fixos")
    public BigDecimal getGastoFixo() {
        return gastoFixo;
    }

    public void setGastoFixo(BigDecimal gastoFixo) {
        this.gastoFixo = gastoFixo;
    }

    @Column(name = "gasto_variavel")
    public BigDecimal getGastoVariavel() {
        return gastoVariavel;
    }

    public void setGastoVariavel(BigDecimal gastoVariavel) {
        this.gastoVariavel = gastoVariavel;
    }

}
