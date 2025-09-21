package com.douglas.enums;

public enum EstadoType implements BaseEnum<String>{

    SIM("S","Sim"),
    NAO("N","Não");

    private String id;
    private String nome;
    
    private EstadoType(String id, String nome) {
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
