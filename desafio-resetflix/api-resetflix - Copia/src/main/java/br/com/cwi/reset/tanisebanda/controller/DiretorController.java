package br.com.cwi.reset.tanisebanda.controller;

import br.com.cwi.reset.tanisebanda.FakeDatabase;
import br.com.cwi.reset.tanisebanda.model.Diretor;
import br.com.cwi.reset.tanisebanda.request.DiretorRequest;
import br.com.cwi.reset.tanisebanda.service.DiretorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diretores")
public class DiretorController {

    private DiretorService diretorService;

    public DiretorController() {
        this.diretorService = new DiretorService(FakeDatabase.getInstance());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarDiretor(@RequestBody DiretorRequest diretorRequest) throws Exception {
        this.diretorService.cadastrarDiretor(diretorRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<Diretor> listarDiretores(String filtroNome) throws Exception {
        return this.diretorService.listarDiretores(filtroNome);
    }

    @GetMapping ("/{id}")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void consultarDiretor(@PathVariable Integer id) throws Exception {
        this.diretorService.consultarDiretor(id);
    }
}

