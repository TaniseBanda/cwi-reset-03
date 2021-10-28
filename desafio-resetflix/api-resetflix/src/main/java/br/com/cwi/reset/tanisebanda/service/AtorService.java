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
    public void criarAtor(AtorRequest atorRequest) throws Exception {
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

            // Integer idGerado = atoresCadastrados.size() + 1;

            //Ator ator = new Ator(atorRequest.getNome(), atorRequest.getDataNascimento(), atorRequest.getStatusCarreira(), atorRequest.getAnoInicioAtividade());


        }
        */
        repository.save(atorRequest);
    }

    //Retorno: List | Método: listarAtoresEmAtividade(String filtroNome)
    public List<AtorEmAtividade> listarAtoresEmAtividade(String filtroNome) throws Exception {
        final List<Ator> atoresCadastrados = repository.findAll();

        if (atoresCadastrados.isEmpty()) {
            throw new ListaVaziaException(TipoDominioException.ATOR.getSingular(), TipoDominioException.ATOR.getPlural());
        }

        final List<AtorEmAtividade> retorno = new ArrayList<>();

        if (filtroNome != null) {
            for (Ator ator : atoresCadastrados) {
                final boolean containsFilter = ator.getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT));
                final boolean emAtividade = StatusCarreira.EM_ATIVIDADE.equals(ator.getStatusCarreira());
                if (containsFilter && emAtividade) {
                    retorno.add(new AtorEmAtividade(ator.getId(), ator.getNome(), ator.getDataNascimento()));
                }
            }
        } else {
            for (Ator ator : atoresCadastrados) {
                final boolean emAtividade = StatusCarreira.EM_ATIVIDADE.equals(ator.getStatusCarreira());
                if (emAtividade) {
                    retorno.add(new AtorEmAtividade(ator.getId(), ator.getNome(), ator.getDataNascimento()));
                }
            }
        }

        if (retorno.isEmpty()) {
            throw new FiltroNomeNaoEncontrado("Ator", filtroNome);
        }

        return retorno;
    }

    // Retorno: Ator | Método: consultarAtor(Integer id)
    public Ator consultarAtor(Integer id) throws Exception {
        return repository.getById(id);
    }

    //Retorno: List | Método: consultarAtores()
    public List<Ator> consultarAtores() throws Exception {
        return repository.findAll();
    }

    //Retorno: void | Método: atualizarAtor(Integer id, AtorRequest atorRequest)
    public void atualizarAtor(Integer id, AtorRequest atorRequest) throws Exception{
        repository.update(id, atorRequest);
    }

    //Retorno: void | Método: removerAtor(Integer id)
    public void removerAtor(Integer id) {
        repository.delete(id);
    }

}