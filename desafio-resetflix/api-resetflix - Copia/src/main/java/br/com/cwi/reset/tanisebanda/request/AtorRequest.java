package br.com.cwi.reset.tanisebanda.request;

import br.com.cwi.reset.tanisebanda.model.StatusCarreira;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class AtorRequest {
    @NotNull(message = "Campo obrigatório não informado.Favor informar o campo nome.")
    private String nome;
    @NotNull(message = "Campo obrigatório não informado.Favor informar o campo dataNascimento.")
    private LocalDate dataNascimento;
    @NotNull(message = "Campo obrigatório não informado.Favor informar o campo statusCarreira.")
    private StatusCarreira statusCarreira;
    @NotNull(message = "Campo obrigatório não informado.Favor informar o campo anoInicioAtividade.")
    private Integer anoInicioAtividade;

    public AtorRequest (String nome, LocalDate dataNascimento, StatusCarreira statusCarreira, Integer anoInicioAtividade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.statusCarreira = statusCarreira;
        this.anoInicioAtividade = anoInicioAtividade;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public StatusCarreira getStatusCarreira() {
        return statusCarreira;
    }

    public Integer getAnoInicioAtividade() {
        return anoInicioAtividade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setStatusCarreira(StatusCarreira statusCarreira) {
        this.statusCarreira = statusCarreira;
    }

    public void setAnoInicioAtividade(Integer anoInicioAtividade) {
        this.anoInicioAtividade = anoInicioAtividade;
    }

    //classe onde vai receber os dados do ator para salvar os dados

}


