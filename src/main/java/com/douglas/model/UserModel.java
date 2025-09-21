package com.douglas.model;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "usuarios")
@NamedEntityGraph(
    name = "userWithFixedIncome",
    attributeNodes = {
        @NamedAttributeNode("fixedIncome")
    }
)
public class UserModel {

    private Integer id;
    private LocalDate dataCadastro;
    private String nome;
    private String rgCpfCnpj;    
    private FixedIncomeModel fixedIncome;
    private String usuario;
    private String email;
    private Date dataDesativacao;

    public UserModel() {
    }

   
    
    public UserModel(Integer id, LocalDate dataCadastro, String nome, String rgCpfCnpj, FixedIncomeModel fixedIncome,
            String usuario, String email, Date dataDesativacao) {
        this.id = id;
        this.dataCadastro = dataCadastro;
        this.nome = nome;
        this.rgCpfCnpj = rgCpfCnpj;
        this.fixedIncome = fixedIncome;
        this.usuario = usuario;
        this.email = email;
        this.dataDesativacao = dataDesativacao;
    }



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
    public LocalDate getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(LocalDate dataCadastro) {
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

    

    @Column(name = "usuario")
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name = "data_desativacao")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDataDesativacao() {
        return dataDesativacao;
    }

    public void setDataDesativacao(Date dataDesativacao) {
        this.dataDesativacao = dataDesativacao;
    }


    @JoinColumn(name = "fixedIncome", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    public FixedIncomeModel getFixedIncome() {
        return fixedIncome;
    }



    public void setFixedIncome(FixedIncomeModel fixedIncome) {
        this.fixedIncome = fixedIncome;
    }

    

}
