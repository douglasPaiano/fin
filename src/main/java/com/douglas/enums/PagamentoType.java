package com.douglas.enums;

public enum PagamentoType implements BaseEnum<String> {

    DEBITO("D", "Débito"),
    CREDITO("C", "Crédito"),
    PARCELADO("P", "Parcelado");

    private String id;
    private String nome;

    private PagamentoType(String id, String nome) {
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
