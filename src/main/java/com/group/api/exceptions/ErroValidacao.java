package com.group.api.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ErroValidacao extends ErroPadrao{

    private List<MensagemCampo> errors = new ArrayList<>();

    public ErroValidacao(Integer status, String msg, Long timeStamp) {
        super(status, msg, timeStamp);
    }

    public List<MensagemCampo> getErrors() {
        return errors;
    }

    public void addError(String campoNome, String msg) {
        errors.add(new MensagemCampo(campoNome, msg));
    }
}
