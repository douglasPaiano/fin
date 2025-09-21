package com.douglas.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.douglas.enums.EnumDefinitions;
import com.douglas.enums.EstadoType;

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
@Table(name = "renda_fixa")
public class FixedIncomeModel {

    private Integer id;
    private UserModel user;
    private EstadoType active;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal income;

    public FixedIncomeModel() {
    }

    public FixedIncomeModel(Integer id, UserModel user, EstadoType active, LocalDate startDate, LocalDate endDate,
            BigDecimal income) {
        this.id = id;
        this.user = user;
        this.active = active;
        this.startDate = startDate;
        this.endDate = endDate;
        this.income = income;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    @Column(name = "ativo")
    @Convert(converter = EnumDefinitions.EstadoCoverter.class)
    public EstadoType getActive() {
        return active;
    }

    public void setActive(EstadoType active) {
        this.active = active;
    }

    @Column(name = "data_inicial")
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Column(name = "data_final")
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    @Column(name = "receita_fixa")
    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    

}
