package br.com.cwi.reset.tanisebanda.exception;

import br.com.cwi.reset.tanisebanda.exception.CampoNaoInformadoException;

public class NomeNaoInformadoException extends CampoNaoInformadoException {
    public NomeNaoInformadoException(){
        super("nome");
    }
}
