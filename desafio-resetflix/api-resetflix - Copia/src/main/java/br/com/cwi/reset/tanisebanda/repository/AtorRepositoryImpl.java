package br.com.cwi.reset.tanisebanda.repository;

// camada de persistência
// único local que vai lidar com a forma de armazenar os dados (memória, disco, banco...)

import br.com.cwi.reset.tanisebanda.model.Ator;
import br.com.cwi.reset.tanisebanda.model.StatusCarreira;
import br.com.cwi.reset.tanisebanda.request.AtorRequest;
import br.com.cwi.reset.tanisebanda.response.AtorEmAtividade;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//métodos utilizados: findBy.../return, salve/.add, delete/.remove, update/busco na lista,.remove,.add, findAll/return.
/*
@Repository
public class AtorRepositoryImpl implements AtorRepository {

    // lista
    private List<Ator> atores = new ArrayList<>();


    //criarAtor(AtorRequest atorRequest)
    public Ator save(Ator ator) {
        atores.add(ator);
        return ator;
    }

    //listarAtoresEmAtividade(String filtroNome)
    public List<Ator> findAll(StatusCarreira statusCarreira) {
        for (Ator atoresEmAtividade : atores) {
            if (atoresEmAtividade.getStatusCarreira().equals(StatusCarreira.EM_ATIVIDADE)) {
                return atores;
            }
        }
        return null;
    }

    //consultarAtor(Integer id)
    public List<Ator> findById(Integer id) {
        for (Ator ator : atores) {
            if (ator.getId().equals(id)) {
                return atores;
            }
        }
        return null;
    }

    //consultarAtor(String nome)
    public List<Ator> findByNome(String nome) {
        for (Ator ator : atores) {
            if (ator.getNome().equals(nome)) {
                return atores;
            }
        }
        return null;
    }

    //consultarAtores()
    public List<Ator> findAll(){
                return atores;
            }

            //removerAtor(Integer id)
            public void delete(Integer id){
                atores.remove(id);
            }

            //atualizarAtor(Integer id, AtorRequest atorRequest)
            public Ator update(AtorRequest atorRequest) {
                Ator atorCadastrado = findById(ator.getId());
                if (atorCadastrado != null) {
                    atores.remove(atorCadastrado);
                    atores.add(atorRequest);
                    return ator;
                }
                return null;
            }

        }

*/