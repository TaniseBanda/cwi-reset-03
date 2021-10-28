package br.com.cwi.reset.tanisebanda.controller;

import br.com.cwi.reset.tanisebanda.FakeDatabase;
import br.com.cwi.reset.tanisebanda.model.Diretor;
import br.com.cwi.reset.tanisebanda.model.Estudio;
import br.com.cwi.reset.tanisebanda.request.EstudioRequest;
import br.com.cwi.reset.tanisebanda.service.EstudioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudios")

public class EstudioController {
    private EstudioService estudioService;

    public EstudioController() {
        this.estudioService = new EstudioService(FakeDatabase.getInstance());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarEstudio(@RequestBody EstudioRequest estudioRequest) throws Exception {
        this.estudioService.criarEstudio(estudioRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<Estudio> consultarEstudios(String filtroNome) throws Exception {
        return this.estudioService.consultarEstudios(filtroNome);
    }

    @GetMapping ("/{id}")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void consultarEstudio(@PathVariable Integer id) throws Exception {
        this.estudioService.consultarEstudio(id);
    }
}
