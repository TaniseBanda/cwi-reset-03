package br.com.cwi.reset.tanisebanda.exception;

import br.com.cwi.reset.tanisebanda.exception.CampoNaoInformadoException;

public class DataNascimentoNaoInformadaException extends CampoNaoInformadoException {
    public DataNascimentoNaoInformadaException() {
        super("dataNascimento");
    }
}
