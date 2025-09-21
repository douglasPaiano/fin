package com.douglas.enums;

public class EnumDefinitions {

    public static class BancoConverter extends EnumConverter<BancoType, String> {

        public BancoConverter() {
            super(BancoType.class);
        }
    }

    public static class CompraConverter extends EnumConverter<CompraType, String> {

        public CompraConverter() {
            super(CompraType.class);
        }

    }

    public static class PagamentoConverter extends EnumConverter<PagamentoType, String> {

        public PagamentoConverter() {
            super(PagamentoType.class);
        }

    }

    public static class TipoGastoConverter extends EnumConverter<TipoGastoType, String> {

        public TipoGastoConverter() {
            super(TipoGastoType.class);
        }
    }

    public static class EstadoCoverter extends EnumConverter<EstadoType, String> {
        public EstadoCoverter() {
            super(EstadoType.class);
        }
    }
    public static class MesFiscalConverter extends EnumConverter<MesFiscalType, String> {
        public MesFiscalConverter() {
            super(MesFiscalType.class);
        }
    }
}
