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
    public void criarAtor(@RequestBody @Valid AtorRequest atorRequest) {
        atorService.criarAtor(atorRequest);
    }

    @GetMapping ("/{id}")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Ator consultarAtor(@PathVariable @Valid Integer id) {
        return atorService.consultarAtor(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<Ator> consultarAtores() {
        return atorService.consultarAtores();
    }

    @GetMapping ("/filtroNome/{nome}")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Ator filtroNome(@PathVariable @Valid String nome) {
        return atorService.filtroNome(nome);
    }

 /*
    @GetMapping("/em_atividade")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<AtorEmAtividade> listarAtoresEmAtividade(@Valid String filtroNome) throws Exception {
        return atorService.listarAtoresEmAtividade(filtroNome);
    }


   // PARTE 3
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void atualizarAtor(@PathVariable @Valid Integer id, @RequestBody @Valid AtorRequest atorRequest) {
        atorService.atualizarAtor(id, atorRequest);
    }

     @DeleteMapping("/{id}")
     @ResponseStatus(HttpStatus.BAD_REQUEST)
     public void removerAtor(@PathVariable @Valid Integer id) {
         atorService.removerAtor(id);
     }


*/


}

