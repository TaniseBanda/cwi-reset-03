package br.com.cwi.reset.tanisebanda.controller;


import br.com.cwi.reset.tanisebanda.model.Ator;
import br.com.cwi.reset.tanisebanda.request.AtorRequest;
import br.com.cwi.reset.tanisebanda.response.AtorEmAtividade;
import br.com.cwi.reset.tanisebanda.service.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//recebe da request e repassa service

@RestController
@RequestMapping("/atores")
public class AtorController {

    // indica a camada abaixo
    @Autowired
    private AtorService atorService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAtor(@RequestBody @Valid AtorRequest atorRequest) throws Exception {
        this.atorService.criarAtor(atorRequest);
    }

    @GetMapping("/em_atividade")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<AtorEmAtividade> listarAtoresEmAtividade(@Valid String filtroNome) throws Exception {
        return this.atorService.listarAtoresEmAtividade(filtroNome);
    }

    @GetMapping ("/{id}")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void consultarAtor(@PathVariable @Valid Integer id) throws Exception {
        this.atorService.consultarAtor(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<Ator> consultarAtores() throws Exception {
        return this.atorService.consultarAtores();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void atualizarAtor(@PathVariable @Valid Integer id, @PathVariable @Valid AtorRequest atorRequest) throws Exception{
        this.atorService.atualizarAtor(id, atorRequest);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void removerAtor(@PathVariable @Valid Integer id) throws Exception {
        this.atorService.removerAtor(id);
    }




}

