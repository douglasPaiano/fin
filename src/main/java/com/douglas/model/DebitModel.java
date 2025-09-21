package com.douglas.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.douglas.enums.CompraType;
import com.douglas.enums.EnumDefinitions;
import com.douglas.enums.PagamentoType;

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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "debitos")
public class DebitModel {

    private Integer Id;
    private InvoiceCycleModel ciclo;
    private UserModel usuario;
    private BigDecimal valor;
    private CompraType tipoCompra;
    private String nomeComprador;
    private PagamentoType tipoPagamento;
    private Integer numeroParcelas;
    private BigDecimal valorParcelas;
    private BigDecimal juros;
    private BigDecimal valorJuros;
    private String localCompra;
    private Date dataCompra;
    private Date dataPagamento;

    public DebitModel(Integer id, InvoiceCycleModel ciclo, UserModel usuario, BigDecimal valor, CompraType tipoCompra,
            String nomeComprador, PagamentoType tipoPagamento, Integer numeroParcelas, BigDecimal valorParcelas,
            BigDecimal juros, BigDecimal valorJuros, String localCompra, Date dataCompra, Date dataPagamento) {
        Id = id;
        this.ciclo = ciclo;
        this.usuario = usuario;
        this.valor = valor;
        this.tipoCompra = tipoCompra;
        this.nomeComprador = nomeComprador;
        this.tipoPagamento = tipoPagamento;
        this.numeroParcelas = numeroParcelas;
        this.valorParcelas = valorParcelas;
        this.juros = juros;
        this.valorJuros = valorJuros;
        this.localCompra = localCompra;
        this.dataCompra = dataCompra;
        this.dataPagamento = dataPagamento;
    }

    public DebitModel() {

    }

    public DebitModel(Integer id) {
        Id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    @JoinColumn(name = "id_ciclo", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    public InvoiceCycleModel getCiclo() {
        return ciclo;
    }

    public void setCiclo(InvoiceCycleModel ciclo) {
        this.ciclo = ciclo;
    }

    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    public UserModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UserModel usuario) {
        this.usuario = usuario;
    }

    @Column(name = "valor")
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Column(name = "tipo_compra")
    @Convert(converter = EnumDefinitions.CompraConverter.class)
    public CompraType getTipoCompra() {
        return tipoCompra;
    }

    public void setTipoCompra(CompraType tipoCompra) {
        this.tipoCompra = tipoCompra;
    }

    @Column(name = "nome_comprador")
    public String getNomeComprador() {
        return nomeComprador;
    }

    public void setNomeComprador(String nomeComprador) {
        this.nomeComprador = nomeComprador;
    }

    @Column(name = "tipo_pagamento")
    @Convert(converter = EnumDefinitions.PagamentoConverter.class)
    public PagamentoType getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(PagamentoType tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    @Column(name = "numero_parcelas")
    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    @Column(name = "valor_parcela")
    public BigDecimal getValorParcelas() {
        return valorParcelas;
    }

    public void setValorParcelas(BigDecimal valorParcelas) {
        this.valorParcelas = valorParcelas;
    }

    @Column(name = "juros")
    public BigDecimal getJuros() {
        return juros;
    }

    public void setJuros(BigDecimal juros) {
        this.juros = juros;
    }

    @Column(name = "valor_juros")
    public BigDecimal getValorJuros() {
        return valorJuros;
    }

    public void setValorJuros(BigDecimal valorJuros) {
        this.valorJuros = valorJuros;
    }

    @Column(name = "local_compra")
    public String getLocalCompra() {
        return localCompra;
    }

    public void setLocalCompra(String localCompra) {
        this.localCompra = localCompra;
    }

    @Column(name = "data_compra")
    @DateTimeFormat(pattern = "yyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    @Column(name = "data_pagamento")
    @DateTimeFormat(pattern = "yyy-MM-dd")
    @Temporal(TemporalType.DATE)
    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

}
