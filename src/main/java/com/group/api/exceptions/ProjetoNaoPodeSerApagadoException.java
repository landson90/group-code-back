package com.group.api.exceptions;

public class ProjetoNaoPodeSerApagadoException extends RuntimeException {


    public ProjetoNaoPodeSerApagadoException(String msg) {
        super(msg);
    }

    public ProjetoNaoPodeSerApagadoException(String msg, Throwable cause) {
        super(msg);
    }
}