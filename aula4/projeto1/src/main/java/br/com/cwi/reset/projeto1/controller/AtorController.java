package br.com.cwi.reset.projeto1.controller;

import br.com.cwi.reset.projeto1.domain.Ator;
import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.repository.AtorRepository;
import br.com.cwi.reset.projeto1.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ator")
public class AtorController {

    private static List<Ator> atores = new ArrayList<>();

    @Autowired
    private AtorRepository repository;

    //cadastro
    @PostMapping
    public Ator cadastrarAtor(@RequestBody Ator ator) {
        repository.save(ator);
        return ator;
    }

    // consulta de ator por nome
    @GetMapping("/{nome}")
    public ResponseEntity<Ator> getByNome(@PathVariable String nome) {
        Ator ator = buscarAtorPeloNome(nome);

        if (ator == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(ator);
    }

    private Ator buscarAtorPeloNome(String nome) {
        for (Ator ator : atores) {
            if (ator.getNome().equals(nome)) {
                return ator;
            }
        }
        return null;
    }

    // consulta ator por numero de oscars
    private Pet buscarAtorPorOscars(Integer numeroOscars) {
        for (Ator ator : atores) {
            if (ator.getNumeroOscars().equals(numeroOscars)) {
                return ator;
            }

            // exclusão de um ator
            @DeleteMapping("/{nome}")
            public void deletarAtor (@PathVariable String nome){
                Ator ator = buscarAtorPeloNome(nome);
                if (ator != null) {
                    atores.remove(ator);
                }
            }


    }
}


