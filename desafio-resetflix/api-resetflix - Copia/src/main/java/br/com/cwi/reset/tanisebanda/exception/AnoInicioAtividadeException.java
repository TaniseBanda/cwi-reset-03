package br.com.cwi.reset.tanisebanda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AnoInicioAtividadeException extends CampoNaoInformadoException {
    public AnoInicioAtividadeException() {
        super("anoInicioAtividade");
    }
}
