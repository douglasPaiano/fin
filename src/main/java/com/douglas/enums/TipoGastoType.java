package com.douglas.enums;

public enum TipoGastoType implements BaseEnum<String> {

    INVESTIMENTO("I", "Investimento"),
    CONSUMO("C", "Consumo");

    private String id;
    private String nome;

    private TipoGastoType(String id, String nome) {
        this.id = id;
        this.nome = nome;
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

    @Override
    public String getId() {
        return id;
    }

}
