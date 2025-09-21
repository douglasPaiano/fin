package com.douglas.model;

import java.math.BigDecimal;

import com.douglas.enums.EnumDefinitions;
import com.douglas.enums.MesFiscalType;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
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
public class BillModel {

    private Integer id;
    private InvoiceCycleModel ciclo;
    private UserModel usuario;
    private BigDecimal receitaTotalMes;
    private BigDecimal receitaFixa;
    private BigDecimal receitaVariavel;
    private BigDecimal gastoTotal;
    private BigDecimal gastoProprio;
    private BigDecimal gastoTerceiros;
    private BigDecimal gastoFixo;
    private BigDecimal gastoVariavel;
    private MesFiscalType mesFiscal;
    private Integer anoFiscal;

    public BillModel() {
    }

    public BillModel(Integer id, InvoiceCycleModel idCiclo, UserModel usuario, BigDecimal receitaTotalMes,
            BigDecimal receitaFixa, BigDecimal receitaVariavel, BigDecimal gastoTotal, BigDecimal gastoProprio,
            BigDecimal gastoTerceiros, BigDecimal gastoFixo, BigDecimal gastoVariavel, MesFiscalType mesFiscal, Integer anoFiscal) {
        this.id = id;
        this.ciclo = idCiclo;
        this.usuario = usuario;
        this.receitaTotalMes = receitaTotalMes;
        this.receitaFixa = receitaFixa;
        this.receitaVariavel = receitaVariavel;
        this.gastoTotal = gastoTotal;
        this.gastoProprio = gastoProprio;
        this.gastoTerceiros = gastoTerceiros;
        this.gastoFixo = gastoFixo;
        this.gastoVariavel = gastoVariavel;
        this.mesFiscal = mesFiscal;
        this.anoFiscal = anoFiscal;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JoinColumn(name = "ciclo", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    public InvoiceCycleModel getCiclo() {
        return ciclo;
    }

    public void setCiclo(InvoiceCycleModel idCiclo) {
        this.ciclo = idCiclo;
    }

    @JoinColumn(name = "usuario", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    public UserModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UserModel usuario) {
        this.usuario = usuario;
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

    @Column(name = "gasto_total")
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

    @Column(name = "gasto_fixo")
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
    
    @Convert(converter = EnumDefinitions.MesFiscalConverter.class)
    public MesFiscalType getMesFiscal() {
        return mesFiscal;
    }

    public void setMesFiscal(MesFiscalType mesFiscal) {
        this.mesFiscal = mesFiscal;
    }

    public Integer getAnoFiscal() {
        return anoFiscal;
    }

    public void setAnoFiscal(Integer anoFiscal) {
        this.anoFiscal = anoFiscal;
    }

    
}
