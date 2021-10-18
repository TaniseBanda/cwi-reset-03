package br.com.cwi.reset.tanisebanda.service;

import br.com.cwi.reset.tanisebanda.FakeDatabase;
import br.com.cwi.reset.tanisebanda.exception.*;
import br.com.cwi.reset.tanisebanda.model.Ator;
import br.com.cwi.reset.tanisebanda.model.StatusCarreira;
import br.com.cwi.reset.tanisebanda.request.AtorRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AtorService {

    private FakeDatabase fakeDatabase;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void criarAtor(AtorRequest atorRequest) throws NomeNaoInformadoException, DataNascimentoNaoInformadaException, AnoInicioAtividadeException, CampoNaoInformadoException, Exception {
       if (atorRequest.getNome() == null){
           throw new NomeNaoInformadoException();
       }
        if (atorRequest.getDataNascimento() == null){
            throw new DataNascimentoNaoInformadaException();
        }
        if (atorRequest.getStatusCarreira() == null){
            throw new CampoNaoInformadoException("statusCarreira");
        }
        if (atorRequest.getAnoInicioAtividade() == null){
            throw new AnoInicioAtividadeException();
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
    ///
    public List<AtorEmAtividade> listarAtoresEmAtividade(String filtroNome) throws Exception {
        final List<Ator> atoresCadastrados = fakeDatabase.recuperaAtores();

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

    public Ator consultarAtor(Integer id) throws Exception {
        if (id == null) {
            throw new IdNaoInformado();
        }

        final List<Ator> atores = fakeDatabase.recuperaAtores();

        for (Ator ator : atores) {
            if (ator.getId().equals(id)) {
                return ator;
            }
        }

        throw new ConsultaIdInvalidoException(TipoDominioException.ATOR.getSingular(), id);
    }

    public List<Ator> consultarAtores() throws Exception {
        final List<Ator> atores = fakeDatabase.recuperaAtores();

        if (atores.isEmpty()) {
            throw new ListaVaziaException(TipoDominioException.ATOR.getSingular(), TipoDominioException.ATOR.getPlural());
        }

        return atores;
    }

}