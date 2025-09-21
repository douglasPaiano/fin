package com.douglas.model;

import com.douglas.enums.BancoType;
import com.douglas.enums.EnumDefinitions;

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
@Table(name = "ciclos_faturas")
public class InvoiceCycleModel {

    private Integer id;
    private UserModel user;
    private Integer openingDay;
    private Integer dueDate;
    private BancoType bank;

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
    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel idUsuario) {
        this.user = idUsuario;
    }

    @Column(name = "dia_abertura")
    public Integer getOpeningDay() {
        return openingDay;
    }

    public void setOpeningDay(Integer openingDay) {
        this.openingDay = openingDay;
    }

    @Column(name = "dia_vencimento")
    public Integer getDueDate() {
        return dueDate;
    }

    public void setDueDate(Integer dueDate) {
        this.dueDate = dueDate;
    }

    @Column(name = "banco")
    @Convert(converter = EnumDefinitions.BancoConverter.class)
    public BancoType getBank() {
        return bank;
    }

    public void setBank(BancoType bank) {
        this.bank = bank;
    }

    public InvoiceCycleModel orElse(Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'orElse'");
    }

}
