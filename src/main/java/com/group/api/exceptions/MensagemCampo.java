package com.group.api.exceptions;

public class MensagemCampo {
    private String campoNome;
    private String mensagem;

    public MensagemCampo() { }

    public MensagemCampo(String campoNome, String mensagem) {
        this.campoNome = campoNome;
        this.mensagem = mensagem;
    }

    public String getCampoNome() {
        return campoNome;
    }

    public void setCampoNome(String campoNome) {
        this.campoNome = campoNome;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
