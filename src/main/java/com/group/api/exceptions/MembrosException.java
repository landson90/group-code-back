package com.group.api.exceptions;

public class MembrosException extends RuntimeException {


    public MembrosException(String msg) {
        super(msg);
    }

    public MembrosException(String msg, Throwable cause) {
        super(msg);
    }
}
