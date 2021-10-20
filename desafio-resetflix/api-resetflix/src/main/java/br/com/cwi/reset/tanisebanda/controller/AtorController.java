package br.com.cwi.reset.tanisebanda.controller;

import br.com.cwi.reset.tanisebanda.FakeDatabase;
import br.com.cwi.reset.tanisebanda.model.Ator;
import br.com.cwi.reset.tanisebanda.model.StatusCarreira;
import br.com.cwi.reset.tanisebanda.request.AtorRequest;
import br.com.cwi.reset.tanisebanda.service.AtorEmAtividade;
import br.com.cwi.reset.tanisebanda.service.AtorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/atores")
public class AtorController {

    private AtorService atorService;

    public AtorController() {
        this.atorService = new AtorService(FakeDatabase.getInstance());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAtor(@RequestBody AtorRequest atorRequest) throws Exception {
        this.atorService.criarAtor(atorRequest);
    }

    @GetMapping("/em_atividade")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<AtorEmAtividade> listarAtoresEmAtividade(String filtroNome) throws Exception {
        return this.atorService.listarAtoresEmAtividade(filtroNome);
    }

    @GetMapping ("/{id}")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void consultarAtor(@PathVariable Integer id) throws Exception {
        this.atorService.consultarAtor(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<Ator> consultarAtores() throws Exception {
        return this.atorService.consultarAtores();
    }

}

