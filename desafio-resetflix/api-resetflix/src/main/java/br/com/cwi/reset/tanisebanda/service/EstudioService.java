package br.com.cwi.reset.tanisebanda.service;

import br.com.cwi.reset.tanisebanda.FakeDatabase;
import br.com.cwi.reset.tanisebanda.exception.*;
import br.com.cwi.reset.tanisebanda.model.Estudio;
import br.com.cwi.reset.tanisebanda.request.EstudioRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static java.util.Objects.isNull;

public class EstudioService {

    private FakeDatabase fakeDatabase;

    public EstudioService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void criarEstudio (EstudioRequest estudioRequest) throws Exception {
        if (estudioRequest.getNome() == null){
            throw new NomeNaoInformadoException();
        }
        if (estudioRequest.getDescricao() == null){
            throw new CampoNaoInformadoException("descricao");
        }
        if (estudioRequest.getDataCriacao() == null){
            throw new CampoNaoInformadoException("dataCriacao");
        }
        if (estudioRequest.getStatusAtividade() == null){
            throw new CampoNaoInformadoException("statusAtividade");
        }

        List<Estudio> estudiosCadastrados = fakeDatabase.recuperaEstudios();

        for (Estudio estudioCadastrados: estudiosCadastrados) {
            if (estudioCadastrados.getNome().equalsIgnoreCase(estudioRequest.getNome())) {
                throw new CadastroDuplicadoException(TipoDominioException.ESTUDIO.getSingular(), estudioRequest.getNome());
            }
        }

        if (!(estudioRequest.getDataCriacao().isBefore(LocalDate.now()))) {
            throw new Exception("Não é possível cadastrar estúdios do futuro.");
        }

        Integer idGerado = estudiosCadastrados.size() + 1;

        Estudio estudio = new Estudio(idGerado, estudioRequest.getNome(), estudioRequest.getDescricao(), estudioRequest.getDataCriacao(), estudioRequest.getStatusAtividade());

        fakeDatabase.persisteEstudio(estudio);
    }

    public List<Estudio> consultarEstudios(final String filtroNome) throws Exception {
        final List<Estudio> estudiosCadastrados = fakeDatabase.recuperaEstudios();
        final List<Estudio> estudios = new ArrayList<>();

        if (estudiosCadastrados.isEmpty()) {
            throw new ListaVaziaException(TipoDominioException.ESTUDIO.getSingular(), TipoDominioException.ESTUDIO.getPlural());
        }
        if (!isNull(filtroNome)) {
            for (Estudio estudio : estudiosCadastrados) {
                if (estudio.getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT))) {
                    estudios.add(estudio);
                }
            }
        } else {
            estudios.addAll(estudiosCadastrados);
        }

        if (estudios.isEmpty()) {
            throw new FiltroNomeNaoEncontrado("Estúdio", filtroNome);
        }

        return estudios;
    }

    public Estudio consultarEstudio(Integer id) throws Exception {
        if (id == null) {
            throw new IdNaoInformado();
        }

        final List<Estudio> estudios = fakeDatabase.recuperaEstudios();

        return fakeDatabase.recuperaEstudios()
                .stream().filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new ConsultaIdInvalidoException(
                                TipoDominioException.ESTUDIO.getSingular(),
                                id)
                );
    }



}


