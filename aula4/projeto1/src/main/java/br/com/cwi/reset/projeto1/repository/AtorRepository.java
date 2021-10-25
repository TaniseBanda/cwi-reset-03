package br.com.cwi.reset.projeto1.repository;

import br.com.cwi.reset.projeto1.domain.Ator;
import br.com.cwi.reset.projeto1.domain.Filme;
import br.com.cwi.reset.projeto1.domain.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtorRepository extends CrudRepository<Ator, Integer> {

    //cadastro
    Ator save(Ator ator);

    // consulta de ator por nome
    Ator findByNome(String nome);

    // consulta ator por numero de oscars
    Ator findByNumeroOscars(Integer numeroOscars);

    // exclusão de um ator
    void delete(Filme filme);

    List<Ator> findAll();
}
