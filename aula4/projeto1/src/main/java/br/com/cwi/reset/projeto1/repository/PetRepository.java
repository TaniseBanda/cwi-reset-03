package br.com.cwi.reset.projeto1.repository;

import br.com.cwi.reset.projeto1.domain.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends CrudRepository<Pet, Integer> {

    Pet findByNomeIgnoringCase(String nome);

    List<Pet> findAll();
}

/*
public interface PetRepository {
    Pet buscarPeloNome(String nome);
    Pet salvar(Pet pet);
    void deletar(Pet pet);
    Pet atualizar(Pet pet);
    List<Pet> listarTodos();
}
*/