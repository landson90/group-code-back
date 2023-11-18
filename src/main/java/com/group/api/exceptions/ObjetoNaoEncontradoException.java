package com.group.api.exceptions;

public class ObjetoNaoEncontradoException extends RuntimeException {



    public ObjetoNaoEncontradoException(String msg) {
        super(msg);
    }

    public ObjetoNaoEncontradoException(String msg, Throwable cause) {
        super(msg);
    }
}