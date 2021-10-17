package br.com.cwi.reset.tanisebanda;

import java.time.LocalDate;
import java.util.List;

public class DiretorService {

    private FakeDatabase fakeDatabase;

    public DiretorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void cadastrarDiretor(DiretorRequest diretorRequest) throws Exception{

        if (diretorRequest.getNome() == null){
            throw new Exception(("\"Campo obrigatório não informado. Favor informar o campo nome."));
        }
        if (diretorRequest.getDataNascimento() == null){
            throw new Exception(("\"Campo obrigatório não informado. Favor informar o campo dataNascimento."));
        }
        if (diretorRequest.getAnoInicioAtividade() == null){
            throw new Exception(("\"Campo obrigatório não informado. Favor informar o campo anoInicioAtividade."));
        }

        if (diretorRequest.getNome().split(" ").length < 2) {
            throw new Exception("Deve ser informado no mínimo nome e sobrenome para o diretor.");
        }

        if (!(diretorRequest.getDataNascimento().isBefore(LocalDate.now()))) {
            throw new Exception("Não é possível cadastrar diretores não nascidos.");
        }

        Integer anoNascimento = diretorRequest.getDataNascimento().getYear();

        if (diretorRequest.getAnoInicioAtividade() < anoNascimento){
            throw new Exception("Ano de início de atividade inválido para o diretor cadastrado.");
        }

        List<Diretor> diretores = fakeDatabase.recuperaDiretores();

        for (Diretor diretoresCadastrados: diretores) {
            if (diretoresCadastrados.getNome().equalsIgnoreCase(diretorRequest.getNome())) {
                throw new Exception (String.format("Já existe um diretor cadastrado para o nome %s." + diretorRequest.getNome()));
            }
        }

        Integer idGerado = diretores.size() + 1;

        Diretor diretor = new Diretor (idGerado,diretorRequest.getNome(), diretorRequest.getDataNascimento(), diretorRequest.getAnoInicioAtividade());
        fakeDatabase.persisteDiretor(diretor);
    }
}
