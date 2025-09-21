package com.douglas.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.douglas.enums.EnumDefinitions;
import com.douglas.enums.EstadoType;
import com.douglas.enums.TipoGastoType;

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
@Table(name = "gastos_fixos")
public class FixedExpensesModel {

    private Integer id;
    private UserModel usuario;
    private TipoGastoType tipoGasto;
    private EstadoType estado;
    private BigDecimal valor;
    private String local;
    private LocalDate dataInicial;
    private LocalDate dataFinal;

    public FixedExpensesModel() {
    }

    public FixedExpensesModel(Integer id, UserModel usuario, TipoGastoType tipoGasto, EstadoType estado,
            BigDecimal valor, String local, LocalDate dataInicial, LocalDate dataFinal) {
        this.id = id;
        this.usuario = usuario;
        this.tipoGasto = tipoGasto;
        this.estado = estado;
        this.valor = valor;
        this.local = local;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JoinColumn(name = "usuario", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    public UserModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UserModel usuario) {
        this.usuario = usuario;
    }

    @Column(name = "tipo_gasto")
    @Convert(converter = EnumDefinitions.TipoGastoConverter.class)
    public TipoGastoType getTipoGasto() {
        return tipoGasto;
    }

    public void setTipoGasto(TipoGastoType tipoGasto) {
        this.tipoGasto = tipoGasto;
    }

    @Column(name = "ativo")
    @Convert(converter = EnumDefinitions.EstadoCoverter.class)
    public EstadoType getEstado() {
        return estado;
    }

    public void setEstado(EstadoType estado) {
        this.estado = estado;
    }

    @Column(name = "valor")
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Column(name = "local")
    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Column(name = "data_inicial")
    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    @Column(name = "data_final")
    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

}
