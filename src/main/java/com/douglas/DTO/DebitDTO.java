package com.douglas.DTO;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.douglas.enums.CompraType;
import com.douglas.enums.PagamentoType;
import com.douglas.model.UserModel;

public class DebitDTO {

    private Integer ciclo;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataCompra;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataPagamento;

    public Integer getCiclo() {
        return ciclo;
    }

    public void setCiclo(Integer ciclo) {
        this.ciclo = ciclo;
    }

    public UserModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UserModel usuario) {
        this.usuario = usuario;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public CompraType getTipoCompra() {
        return tipoCompra;
    }

    public void setTipoCompra(CompraType tipoCompra) {
        this.tipoCompra = tipoCompra;
    }

    public String getNomeComprador() {
        return nomeComprador;
    }

    public void setNomeComprador(String nomeComprador) {
        this.nomeComprador = nomeComprador;
    }

    public PagamentoType getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(PagamentoType tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public BigDecimal getValorParcelas() {
        return valorParcelas;
    }

    public void setValorParcelas(BigDecimal valorParcelas) {
        this.valorParcelas = valorParcelas;
    }

    public BigDecimal getJuros() {
        return juros;
    }

    public void setJuros(BigDecimal juros) {
        this.juros = juros;
    }

    public BigDecimal getValorJuros() {
        return valorJuros;
    }

    public void setValorJuros(BigDecimal valorJuros) {
        this.valorJuros = valorJuros;
    }

    public String getLocalCompra() {
        return localCompra;
    }

    public void setLocalCompra(String localCompra) {
        this.localCompra = localCompra;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }
    public Date getDataPagamento() {
        return dataPagamento;
    }
    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

}
