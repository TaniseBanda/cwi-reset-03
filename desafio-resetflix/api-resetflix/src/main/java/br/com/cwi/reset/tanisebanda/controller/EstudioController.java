package br.com.cwi.reset.tanisebanda.controller;

import br.com.cwi.reset.tanisebanda.FakeDatabase;
import br.com.cwi.reset.tanisebanda.service.EstudioService;
import br.com.cwi.reset.tanisebanda.service.FilmeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estudios")

public class EstudioController {
    private EstudioService estudioService;

    public EstudioController() {
        this.estudioService = new EstudioService(FakeDatabase.getInstance());
    }

}
