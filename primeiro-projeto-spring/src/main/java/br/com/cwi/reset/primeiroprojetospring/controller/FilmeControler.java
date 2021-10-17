package br.com.cwi.reset.primeiroprojetospring.controller;
//um endpoint do tipo GET para /filme que nos retorne um filme.
//Deve ser instanciado um objeto Filme com todas propriedades preenchidas

import br.com.cwi.reset.primeiroprojetospring.domain.Diretor;
import br.com.cwi.reset.primeiroprojetospring.domain.Filme;
import br.com.cwi.reset.primeiroprojetospring.domain.Genero;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/filme")

public class FilmeControler {

    //@GetMapping
    //public Filme consultarFilme() {
    //    return new Filme("Interestelar", "Filme muito bom", 120, 2014, 5.0, new Diretor("Christopher Nolan", LocalDate.now(), 20, Genero.MASCULINO));
    // }
    private static List<Filme> filmes = new ArrayList<>();

    @PostMapping // cadastro do filme pelo endpoint
    public ResponseEntity<Filme> cadastrarFilme(@RequestBody Filme filme) {
        Filme filmeExistente = buscarPorNome((filme.getNome());
        if (filmeExistente != null) {
            return ResponseEntity.badRequest().build();
        }
        filmes.add(filme);
        return ResponseEntity.ok(filme);
    }

    private Filme buscarPorNome(String nome) {
        for (Filme filme : filmes) {
            if (filme.getNome().equals(nome)) {
                return filme;
            }
        }
        return null;
    }

    @GetMapping // busca para todos os filmes cadastrados
    public List<Filme> consultarTodos() {
        return filmes;
    }

    @GetMapping("/{nome}") // busca para filme descrito através do nome
    public Filme buscarPorNome(@PathVariable String nome) {
        return buscarPorNome(nome);
    }



    @DeleteMapping("/{nome}") // remoção de um filme
    public void deletarFilme(@PathVariable String nome) {
        Filme filme = buscarPorNome(nome);
        if (filme != null) {
            filmes.remove(filme);
        }
    }

    @PutMapping // atualização de um filme
    public void atualizarFilme(@RequestBody Filme filme) {
        Filme filmeExistente = buscarPorNome(filme.getNome());

        if (filmeExistente != null) {
            filmes.remove(filmeExistente);
            filmes.add(filme);

        }
    }

}

/*
Deve validar se já não existe um filme com o nome informado, caso exista, retornar um status code 400 (Bad Request)
Ajustar o método GET que fizemos anteriormente para receber o nome do filme a ser consultado e retornar o filme devidamente.
 */