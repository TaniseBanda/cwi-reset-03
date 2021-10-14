package br.com.cwi.reset.tanisebanda;

import java.time.LocalDate;

public class Filme {
    private Integer id;
    private String nome;
    private LocalDate anoLancamento;
    private Boolean capaFilme; // tipo?
    private Generos generos;
    private Diretor diretor;
    private PersonagemAtor personagens;
    private String resumo;

    public Filme(Integer id, String nome, LocalDate anoLancamento, Boolean capaFilme, Generos generos, Diretor diretor, PersonagemAtor personagens, String resumo) {
        this.id = id;
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.capaFilme = capaFilme;
        this.generos = generos;
        this.diretor = diretor;
        this.personagens = personagens;
        this.resumo = resumo;
    }
}
