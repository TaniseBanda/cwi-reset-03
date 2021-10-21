package br.com.cwi.reset.tanisebanda.service;

import br.com.cwi.reset.tanisebanda.FakeDatabase;
import br.com.cwi.reset.tanisebanda.exception.CampoNaoInformadoException;
import br.com.cwi.reset.tanisebanda.exception.NomeNaoInformadoException;
import br.com.cwi.reset.tanisebanda.model.Ator;
import br.com.cwi.reset.tanisebanda.model.Estudio;
import br.com.cwi.reset.tanisebanda.model.Filme;
import br.com.cwi.reset.tanisebanda.model.PersonagemAtor;
import br.com.cwi.reset.tanisebanda.request.FilmeRequest;

import java.util.List;

public class FilmeService {

    private FakeDatabase fakeDatabase;

    public FilmeService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    private AtorService atorService;
    private DiretorService diretorService;
    private EstudioService estudioService;


    public FilmeService(FakeDatabase fakeDatabase, AtorService atorService, DiretorService diretorService, EstudioService estudioService) {
        this.fakeDatabase = fakeDatabase;
        this.atorService = new AtorService(FakeDatabase.getInstance());
        this.diretorService = new DiretorService(FakeDatabase.getInstance());
        this.estudioService = new EstudioService(FakeDatabase.getInstance());

    }

    public void criarFilme (FilmeRequest filmeRequest) throws Exception {
        if (filmeRequest.getNome() == null) {
            throw new NomeNaoInformadoException();
        }
        if (filmeRequest.getAnoLancamento() == null) {
            throw new CampoNaoInformadoException("anoLancamento");

        }
        if (filmeRequest.getCapaFilme() == null) {
            throw new CampoNaoInformadoException("capaFilme");
        }
        if (filmeRequest.getGeneros() == null) {
            throw new CampoNaoInformadoException("genero");
        }
        if (filmeRequest.getResumo() == null) {
            throw new CampoNaoInformadoException("resumo");
        }

        /* Faltou incluir nas exceções campos obrigatorios:
        idDiretor*
        idEstudio*
        List< PersonagemRequest > personagens*
              idAtor*
              nomePersonagem*
              descricaoPersonagem*
              TipoAtuacao tipoAtuacao*
                  PRINCIPAL
                  COADJUVANTE

          // e demais exceções:
            1 - Caso não exista nenhum estúdio cadastrado para o id informado deve retornar erro
                Mensagem de erro: "Nenhum estúdio encontrado com o parâmetro id={id}, favor verifique os parâmetros informados."
            2 - Caso não exista nenhum diretor cadastrado para o id informado deve retornar erro
                Mensagem de erro: "Nenhum diretor encontrado com o parâmetro id={id}, favor verifique os parâmetros informados."
            3 - Caso não exista nenhum ator cadastrado para o id informado deve retornar erro
                Mensagem de erro: "Nenhum ator encontrado com o parâmetro id={id}, favor verifique os parâmetros informados."
            4 - É obrigatório informar pelo menos um gênero na lista, caso não informado deve retornar erro:
                Mensagem de erro: "Deve ser informado pelo menos um gênero para o cadastro do filme."
            5 - Não é permitido cadastrar filmes que apresentem duas vezes o mesmo gênero na lista informada na requisição, caso encontrado gêneros duplicados deve retornar mensagem de erro, exemplo:
                List< Generos > generos : ["ACAO", "TERROR", "COMEDIA", "ACAO"] | não permitido
                List< Generos > generos : ["ACAO", "TERROR", "COMEDIA", "ESPIONAGEM"] | permitido
                Mensagem de erro: "Não é permitido informar o mesmo gênero mais de uma vez para o mesmo filme."
            6 - Não é permitido cadastrar o mesmo personagem com o mesmo ator mais de uma vez, caso seja informado o mesmo ator para o mesmo personagem deve retornar erro, exemplo:
                List< PersonagemRequest > personagens : [{"idAtor": 1, "nomePersonagem": "meu personagem"}, {"idAtor": 2, "nomePersonagem": "outro personagem"}, {"idAtor": 1, "nomePersonagem": "meu personagem"}] | não permitido
                List< PersonagemRequest > personagens : [{"idAtor": 1, "nomePersonagem": "meu personagem"}, {"idAtor": 2, "nomePersonagem": "outro personagem"}, {"idAtor": 3, "nomePersonagem": "meu personagem"}] | permitido
                List< PersonagemRequest > personagens : [{"idAtor": 1, "nomePersonagem": "meu personagem"}, {"idAtor": 2, "nomePersonagem": "outro personagem"}, {"idAtor": 1, "nomePersonagem": "mais um personagem para o ator 1"}] | permitido
                Mensagem de erro: "Não é permitido informar o mesmo ator/personagem mais de uma vez para o mesmo filme."

         */

        List<Filme> filmes = fakeDatabase.recuperaFilmes();
        Integer idGerado = filmes.size() + 1;

        List<PersonagemAtor> personagens = fakeDatabase.recuperaPersonagens();
        Integer idGeradoPersonagem = personagens.size() + 1;

        //Filme filme = new Filme(idGerado, filmeRequest.getNome(), filmeRequest.getAnoLancamento(), filmeRequest.getCapaFilme(), filmeRequest.getGeneros());

        //fakeDatabase.persisteFilme(filme);

    }


}
