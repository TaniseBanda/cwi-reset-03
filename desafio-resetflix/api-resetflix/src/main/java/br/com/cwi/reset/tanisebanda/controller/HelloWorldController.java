package br.com.cwi.reset.tanisebanda.controller;

import br.com.cwi.reset.tanisebanda.exception.NomeNaoInformadoException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {
    
    @PostMapping
    public String helloWorld() throws Exception {
        throw new NomeNaoInformadoException();
        //return "Minha API resetflix está UP!!!";
    }
}