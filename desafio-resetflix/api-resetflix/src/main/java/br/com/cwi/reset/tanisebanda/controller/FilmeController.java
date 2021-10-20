package br.com.cwi.reset.tanisebanda.controller;

import br.com.cwi.reset.tanisebanda.FakeDatabase;
import br.com.cwi.reset.tanisebanda.service.FilmeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private FilmeService filmeService;

    public FilmeController() {
        this.filmeService = new FilmeService(FakeDatabase.getInstance());
    }
}
