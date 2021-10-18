package br.com.cwi.reset.tanisebanda.service;

import br.com.cwi.reset.tanisebanda.FakeDatabase;
import br.com.cwi.reset.tanisebanda.exception.*;
import br.com.cwi.reset.tanisebanda.model.Diretor;
import br.com.cwi.reset.tanisebanda.request.DiretorRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DiretorService {

    private FakeDatabase fakeDatabase;

    public DiretorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void cadastrarDiretor(DiretorRequest diretorRequest) throws Exception{

        if (diretorRequest.getNome() == null){
            throw new NomeNaoInformadoException();
        }
        if (diretorRequest.getDataNascimento() == null){
            throw new DataNascimentoNaoInformadaException();
        }
        if (diretorRequest.getAnoInicioAtividade() == null){
            throw new AnoInicioAtividadeException();
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

    //
    public List<Diretor> listarDiretores(final String filtroNome) throws Exception {
        final List<Diretor> diretoresCadastrados = fakeDatabase.recuperaDiretores();

        if (diretoresCadastrados.isEmpty()) {
            throw new ListaVaziaException(TipoDominioException.DIRETOR.getSingular(), TipoDominioException.DIRETOR.getPlural());
        }

        final List<Diretor> retorno = new ArrayList<>();

        if (filtroNome != null) {
            for (Diretor diretor : diretoresCadastrados) {
                final boolean containsFilter = diretor.getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT));
                if (containsFilter) {
                    retorno.add(diretor);
                }
            }
        } else {
            retorno.addAll(diretoresCadastrados);
        }

        if (retorno.isEmpty()) {
            throw new FiltroNomeNaoEncontrado("Diretor", filtroNome);
        }

        return retorno;
    }

    public Diretor consultarDiretor(final Integer id) throws Exception {
        if (id == null) {
            throw new IdNaoInformado();
        }

        final List<Diretor> diretores = fakeDatabase.recuperaDiretores();

        for (Diretor diretor : diretores) {
            if (diretor.getId().equals(id)) {
                return diretor;
            }
        }

        throw new ConsultaIdInvalidoException(TipoDominioException.DIRETOR.getSingular(), id);
    }
}
