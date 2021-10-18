package br.com.cwi.reset.tanisebanda.exception;

import br.com.cwi.reset.tanisebanda.exception.CampoNaoInformadoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DataNascimentoNaoInformadaException extends CampoNaoInformadoException {
    public DataNascimentoNaoInformadaException() {
        super("dataNascimento");
    }
}
