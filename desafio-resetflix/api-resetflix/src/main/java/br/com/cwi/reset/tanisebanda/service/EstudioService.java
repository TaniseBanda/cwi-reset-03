package br.com.cwi.reset.tanisebanda.service;

import br.com.cwi.reset.tanisebanda.FakeDatabase;
import br.com.cwi.reset.tanisebanda.exception.*;
import br.com.cwi.reset.tanisebanda.model.Estudio;
import br.com.cwi.reset.tanisebanda.request.EstudioRequest;

import java.time.LocalDate;
import java.util.List;

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

        List<Estudio> estudios = fakeDatabase.recuperaEstudios();

        for (Estudio estudiosCadastrados: estudios) {
            if (estudiosCadastrados.getNome().equalsIgnoreCase(estudioRequest.getNome())) {
                throw new Exception (String.format("Já existe um estúdio cadastrado para o nome %s." + estudioRequest.getNome()));
            }
        }

        if (!(estudioRequest.getDataCriacao().isBefore(LocalDate.now()))) {
            throw new Exception("Não é possível cadastrar estúdios do futuro.");
        }

        Integer idGerado = estudios.size() + 1;

        Estudio estudio = new Estudio(idGerado, estudioRequest.getNome(), estudioRequest.getDescricao(), estudioRequest.getDataCriacao(), estudioRequest.getStatusAtividade());

        fakeDatabase.persisteEstudio(estudio);
    }

    public List<Estudio> consultarEstudios(final String filtroNome) throws Exception {
        final List<Estudio> estudios = fakeDatabase.recuperaEstudios();

        if (estudios.isEmpty()) {
            throw new CampoNaoInformadoException("Nenhum estúdio cadastrado, favor cadastar estúdios.");
        }
        return estudios;
    }
/* Não fiz:
1 O campo filtroNome é opcional, quando informado deve filtrar por qualquer match na sequência do nome, Exemplo: filtroNome -> vel estúdio encontrado -> Marvel Studios
3 Caso não seja encontrado nenhum estúdio com o filtro informado deve retornar erro
Mensagem de erro: "Estúdio não encontrado com o filtro {filtro}, favor informar outro filtro."
 */

    public Estudio consultarEstudio(Integer id) throws Exception {
        if (id == null) {
            throw new IdNaoInformado();
        }

        final List<Estudio> estudios = fakeDatabase.recuperaEstudios();

        for (Estudio estudio : estudios) {
            if (estudio.getId().equals(id)) {
                return estudio;
            }
        }

        throw new ConsultaIdInvalidoException(TipoDominioException.ESTUDIO.getSingular(), id);
    }

}


