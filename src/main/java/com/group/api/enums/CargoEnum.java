package com.group.api.enums;

public enum CargoEnum {
    GERENTE("gerente"),
    DEV("dev");


    private final String descricao;

    CargoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
