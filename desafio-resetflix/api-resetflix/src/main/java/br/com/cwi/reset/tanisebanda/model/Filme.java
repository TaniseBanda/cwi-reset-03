package br.com.cwi.reset.tanisebanda.model;

import java.time.LocalDate;
import java.util.List;

public class Filme {
    private Integer id;
    private String nome;
    private LocalDate anoLancamento;
    private String capaFilme;
    private List<Genero> generos;
    private Diretor diretor;
    private List<PersonagemAtor> personagens;
    private String resumo;

    public Filme(Integer id, String nome, LocalDate anoLancamento, String capaFilme, List<Genero> generos, Diretor diretor, List<PersonagemAtor> personagens, String resumo) {
        this.id = id;
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.capaFilme = capaFilme;
        this.generos = generos;
        this.diretor = diretor;
        this.personagens = personagens;
        this.resumo = resumo;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getAnoLancamento() {
        return anoLancamento;
    }

    public String getCapaFilme() {
        return capaFilme;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public List<PersonagemAtor> getPersonagens() {
        return personagens;
    }

    public String getResumo() {
        return resumo;
    }
}
