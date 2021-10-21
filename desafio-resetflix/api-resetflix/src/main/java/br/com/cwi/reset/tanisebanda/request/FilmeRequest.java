package br.com.cwi.reset.tanisebanda.request;

import br.com.cwi.reset.tanisebanda.model.Diretor;
import br.com.cwi.reset.tanisebanda.model.Estudio;
import br.com.cwi.reset.tanisebanda.model.Genero;

import java.time.LocalDate;
import java.util.List;

public class FilmeRequest {
    private String nome;
    private LocalDate anoLancamento;
    private String capaFilme;
    private List<Genero> generos;
    private Diretor diretor;
    private Estudio estudio;
    private String resumo;
    private List<PersonagemRequest> personagens;

    public FilmeRequest(String nome, LocalDate anoLancamento, String capaFilme, List<Genero> generos, Diretor diretor, Estudio estudio, String resumo, List<PersonagemRequest> personagens) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.capaFilme = capaFilme;
        this.generos = generos;
        this.diretor = diretor;
        this.estudio = estudio;
        this.resumo = resumo;
        this.personagens = personagens;
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

    public Estudio getEstudio() {
        return estudio;
    }

    public String getResumo() {
        return resumo;
    }

    public List<PersonagemRequest> getPersonagens() {
        return personagens;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoLancamento(LocalDate anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public void setCapaFilme(String capaFilme) {
        this.capaFilme = capaFilme;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public void setPersonagens(List<PersonagemRequest> personagens) {
        this.personagens = personagens;
    }

}


