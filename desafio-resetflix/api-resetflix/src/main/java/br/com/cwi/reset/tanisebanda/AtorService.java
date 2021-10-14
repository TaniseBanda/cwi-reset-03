package br.com.cwi.reset.tanisebanda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AtorService {

    private FakeDatabase fakeDatabase;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    // objetivo desta classe é incluir um novo ator na lista de atores que esta na classe AtorRequest

    List<Ator> listaAtores =  new ArrayList<>();


    // sei que nao esta certo...
    // como validar os campos e todas exceptions antes de criar o ator?
    // uso o mesmo metodo de criar ator? (acho que sim)
    // como busco os campos (atributo herança de outra classe)???? AtorService tb extend Ator e tem metodo constructor?

    public void criarAtor(AtorRequest atorRequest) {
        listaAtores.add(atorRequest);
    }

    public void validaCampoNome throws CampoObrigatorioException {
        if (nome == null) {
            String campo = "Nome";
            throw new CampoObrigatorioException();
        }
        return nome;
    }

    public void validaCampoDataNascimento throws CampoObrigatorioException {
        if (dataNascimento == null) {
            String campo = "Data de Nascimento";
            throw new CampoObrigatorioException();
        }
        return dataNascimento;
    }

    public void validaCampoStatusCarreira throws CampoObrigatorioException {
        if (statusCarreira == null) {
            String campo = "Status Carreira";
            throw new CampoObrigatorioException();
        }
        return statusCarreira;
}

    public void validaCampoAnoInicioAtividade throws CampoObrigatorioException {
        if (anoInicioAtividade == null) {
            String campo = "Ano Inicio Atividade";
            throw new CampoObrigatorioException();
        }
        return anoInicioAtividade;
    }

    public void validaDataNascimento throws ValidaDataNascimentoException {
        if (!(dataNascimento.isBefore(LocalDate.now()))) {
            throw new ValidaDataNascimentoException();
        }
        return dataNascimento;
    }

    public void validaAnoInicioAtividade throws ValidaAnoInicioAtividadeException {
        LocalDate current_date = LocalDate.now();
        int current_Year = current_date.getYear();
        if (anoInicioAtividade < current_date.getYear()) {
            throw new ValidaAnoInicioAtividadeException();
        }
        return anoInicioAtividade;
    }


    // List<String> listaAtores =  new ArrayList<>();
    // listaAtores.add(onde pego os dados do ator adicionado?)

    public void campoNome (String nome)  {


    }

}