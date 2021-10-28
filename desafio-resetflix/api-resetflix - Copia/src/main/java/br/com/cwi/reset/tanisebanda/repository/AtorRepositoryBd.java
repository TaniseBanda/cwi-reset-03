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

    List<Ator> findByStatusCarreira(String filtroNome);

    Ator getById(Integer id);

    List<Ator> findAll();

    void update(Integer id, AtorRequest atorRequest);

    void delete(Integer id);

}
