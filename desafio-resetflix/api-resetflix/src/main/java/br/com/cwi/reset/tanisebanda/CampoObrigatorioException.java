package br.com.cwi.reset.tanisebanda;

public class CampoObrigatorioException extends Exception {

    public CampoObrigatorioException(){
        String campo;
        super("Campo obrigatório não informado. Favor informar o " + campo + ".");
    }
}
