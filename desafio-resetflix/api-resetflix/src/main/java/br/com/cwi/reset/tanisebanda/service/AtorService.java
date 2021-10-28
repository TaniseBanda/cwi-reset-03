package br.com.cwi.reset.tanisebanda.service;

import br.com.cwi.reset.tanisebanda.exception.*;
import br.com.cwi.reset.tanisebanda.model.Ator;
import br.com.cwi.reset.tanisebanda.model.StatusCarreira;
import br.com.cwi.reset.tanisebanda.repository.AtorRepositoryBd;
import br.com.cwi.reset.tanisebanda.request.AtorRequest;
import br.com.cwi.reset.tanisebanda.response.AtorEmAtividade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

//objetivo da camada de serviço é processar as regras de negócio
//não é responsável por persistir os dados
//não utiliza protocolo HTTP
@Service
public class AtorService {

    // indica a camada abaixo (injeta do repository)
    @Autowired
    private AtorRepositoryBd repository;

    // Retorno: void | Método: criarAtor(AtorRequest atorRequest)
    public void criarAtor(AtorRequest atorRequest) {
        /*
        if (atorRequest.getNome().split(" ").length < 2) {
            throw new Exception("Deve ser informado no mínimo nome e sobrenome para o ator.");
        }

        if (!(atorRequest.getDataNascimento().isBefore(LocalDate.now()))) {
            throw new Exception("Não é possível cadastrar atores não nascidos.");
        }

        Integer anoNascimento = atorRequest.getDataNascimento().getYear();
        if (atorRequest.getAnoInicioAtividade() < anoNascimento) {
            throw new Exception("Ano de início de atividade inválido para o ator cadastrado.");
        }

        final List<Ator> atoresCadastrados = repository.findAll();
        for (Ator atorCadastrado : atoresCadastrados) {
            if (atorCadastrado.getNome().equalsIgnoreCase(atorRequest.getNome())) {
                throw new Exception(String.format("Já existe um ator cadastrado para o nome %s." + atorRequest.getNome()));
            }

            Integer idGerado = 1;

            Ator ator = new Ator( atorRequest.getNome(), atorRequest.getDataNascimento(), atorRequest.getStatusCarreira(), atorRequest.getAnoInicioAtividade());

            repository.save(ator);


        }
*/

        Ator ator = new Ator(atorRequest.getNome(), atorRequest.getDataNascimento(), atorRequest.getStatusCarreira(), atorRequest.getAnoInicioAtividade());

        repository.save(ator);
    }

    //Retorno: Ator | Método: consultarAtor(Integer id)
    public Ator consultarAtor(Integer id) {
        return repository.findByIdEquals(id);
    }

    //Retorno: List | Método: consultarAtores()
    public List<Ator> consultarAtores() {
        return repository.findAll();
    }

    //Retorno: Ator | Método: filtroNome (String nome -> para usar na lista atores em atividade)
    public List<Ator> filtroNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    //tá compilando mas não deu
    public List<Ator> listarAtoresEmAtividade(String filtroNome) {
        List<Ator> atoresFiltrados = repository.findByNomeContainingIgnoreCase(filtroNome);
        final List<AtorEmAtividade> retorno = new ArrayList<>();
        for (Ator ator : atoresFiltrados) {
            if (ator.getStatusCarreira().equals(StatusCarreira.EM_ATIVIDADE)) {
                return repository.findByStatusCarreira(filtroNome);
            }
        } return null;
    }
}




/* PARTE 3

    //Retorno: void | Método: removerAtor(Integer id)
    public void removerAtor(Integer id) {
        //Ator ator = repository.findByIdEquals(id);
        repository.deleteById(id);
    }

    //Retorno: void | Método: atualizarAtor(Integer id, AtorRequest atorRequest)
    public void atualizarAtor(Integer id, AtorRequest atorRequest) {
        repository.save(id, atorRequest);
    }

*/
