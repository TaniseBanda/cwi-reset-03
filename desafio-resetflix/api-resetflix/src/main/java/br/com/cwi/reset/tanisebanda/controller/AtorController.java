package br.com.cwi.reset.tanisebanda.controller;

import br.com.cwi.reset.tanisebanda.FakeDatabase;
import br.com.cwi.reset.tanisebanda.model.Ator;
import br.com.cwi.reset.tanisebanda.request.AtorRequest;
import br.com.cwi.reset.tanisebanda.service.AtorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atores")
public class AtorController {

    private AtorService atorService;

    public AtorController() {
        this.atorService = new AtorService(FakeDatabase.getInstance());
    }

    //demais métodos

    //public List<Ator> consultarAtores() {
    //   this.atorService.consultarAtores();
    //}
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAtor(@RequestBody AtorRequest atorRequest) throws Exception {
        this.atorService.criarAtor(atorRequest);
    }

}