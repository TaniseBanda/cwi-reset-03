package br.com.cwi.reset.tanisebanda.exception;

import br.com.cwi.reset.tanisebanda.exception.CampoNaoInformadoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NomeNaoInformadoException extends CampoNaoInformadoException {
    public NomeNaoInformadoException(){
        super("nome");
    }
}
