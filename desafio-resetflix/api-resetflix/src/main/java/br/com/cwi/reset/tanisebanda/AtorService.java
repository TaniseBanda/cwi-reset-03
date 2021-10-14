package br.com.cwi.reset.tanisebanda;

import java.util.ArrayList;
import java.util.List;

public class AtorService {

    private FakeDatabase fakeDatabase;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    // objetivo desta classe é incluir um novo ator na lista de atores que esta na classe AtorRequest

    List<Ator> listaAtores =  new ArrayList<>();

    public void criarAtor(AtorRequest atorRequest){
        listaAtores.add(atorRequest);
    }

    // List<String> listaAtores =  new ArrayList<>();
    // listaAtores.add(onde pego os dados do ator adicionado?)

    public void campoNome (String nome) throws CampoObrigatorioException {
        String campo = "Nome";
        if (nome == null){
            throw new CampoObrigatorioException();
        }
    }

}