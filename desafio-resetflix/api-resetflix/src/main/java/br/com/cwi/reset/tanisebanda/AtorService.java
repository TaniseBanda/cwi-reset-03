package br.com.cwi.reset.tanisebanda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AtorService {

    private FakeDatabase fakeDatabase;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void criarAtor(AtorRequest atorRequest) throws Exception {
       if (atorRequest.getNome() == null){
           throw new Exception(("\"Campo obrigatório não informado. Favor informar o campo nome."));
       }
        if (atorRequest.getDataNascimento() == null){
            throw new Exception(("\"Campo obrigatório não informado. Favor informar o campo dataNascimento."));
        }
        if (atorRequest.getStatusCarreira() == null){
            throw new Exception(("\"Campo obrigatório não informado. Favor informar o campo statusCarreira."));
        }
        if (atorRequest.getAnoInicioAtividade() == null){
            throw new Exception(("\"Campo obrigatório não informado. Favor informar o campo anoInicioAtividade."));
        }

        List<Ator> atores = fakeDatabase.recuperaAtores();

        if (atorRequest.getNome().split(" ").length < 2) {
            throw new Exception("Deve ser informado no mínimo nome e sobrenome para o ator.");
        }

        if (!(atorRequest.getDataNascimento().isBefore(LocalDate.now()))) {
            throw new Exception("Não é possível cadastrar atores não nascidos.");
        }

        Integer anoNascimento = atorRequest.getDataNascimento().getYear();
        if (atorRequest.getAnoInicioAtividade() < anoNascimento){
            throw new Exception("Ano de início de atividade inválido para o ator cadastrado.");
        }

        for (Ator atoresCadastrados: atores) {
            if (atoresCadastrados.getNome().equalsIgnoreCase(atorRequest.getNome())) {
                throw new Exception (String.format("Já existe um ator cadastrado para o nome %s." + atorRequest.getNome()));
            }
        }

        Integer idGerado = atores.size() + 1;

        Ator ator = new Ator(idGerado, atorRequest.getNome(), atorRequest.getDataNascimento(), atorRequest.getStatusCarreira(), atorRequest.getAnoInicioAtividade());

        fakeDatabase.persisteAtor(ator);
    }


}