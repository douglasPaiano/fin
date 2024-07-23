package com.douglas.enums;

public enum BancoType {

    NUBANK("1","Nubank"),
    BB("2","Banco do Brasil"),
    SICREDI("3","Sicredi");

    private String id;
    private String nome;

    BancoType(String id, String nome) {
        setId(id);
        setNome(nome);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    

}
