package br.com.cwi.reset.tanisebanda.exception;

public class CampoNaoInformadoException extends Exception {
    public CampoNaoInformadoException(String campo) {
        super (String.format("Campo obrigatório não informado. Favor informar o campo %s.", campo));
    }
}
