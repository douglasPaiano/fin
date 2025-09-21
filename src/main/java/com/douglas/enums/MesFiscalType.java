package com.douglas.enums;

public enum MesFiscalType implements BaseEnum<String> {

    janFev("1", "Janeiro - Fevereiro"),
    fevMar("2", "Fevereiro - Março"),
    marAbr("3", "Março - Abril"),
    abrMai("4", "Abril - Maio"),    
    maijun("5", "Maio - Junho"),
    junJul("6", "Junho - Julho"),
    julAgo("7", "Julho - Agosto"),
    agoSet("8", "Agosto - Setembro"),
    setOut("9", "Setembro - Outubro"),
    outNov("10", "Outubro - Novembro"),
    novDez("11", "Novembro - Dezembro"),
    dezJan("12", "Dezembro - Janeiro");

    private String id;
    private String nome;

    private MesFiscalType(String id, String nome) {
        this.id = id;
        this.nome = nome;
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

     public static MesFiscalType fromId(String id) {
        for (MesFiscalType mes : values()) {
            if (mes.getId().equals(id)) {
                return mes;
            }
        }
        return null;
    }

}
