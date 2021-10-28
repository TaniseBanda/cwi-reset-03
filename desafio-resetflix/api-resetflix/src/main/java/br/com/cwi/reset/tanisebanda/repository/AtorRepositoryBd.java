package br.com.cwi.reset.tanisebanda.repository;

import br.com.cwi.reset.tanisebanda.model.Ator;
import br.com.cwi.reset.tanisebanda.request.AtorRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// define os contratos que disponho, mas nao a real implementação...
@Repository
public interface AtorRepositoryBd extends CrudRepository<Ator, Integer> {

    void save(AtorRequest atorRequest);

    Ator findByIdEquals(Integer id);

    List<Ator> findAll();

    Ator findByNome(String nome);


/*
    List<Ator> findByStatusCarreira(String filtroNome);

    void delete(Integer id);

    void save(Integer id, AtorRequest atorRequest);

*/
}
