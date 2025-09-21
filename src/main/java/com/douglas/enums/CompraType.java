package com.douglas.enums;

public enum CompraType implements BaseEnum<String> {

    PROPRIA("P", "Pessoal"),
    TERCEIROS("T", "Terceiros");

    private String id;
    private String nome;

    private CompraType(String id, String nome) {
       setId(id);
       setNome(nome);
    }

    @Override
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
