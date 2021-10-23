package br.com.cwi.reset.projeto1.service;

import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.exception.PetJaExistenteException;
import br.com.cwi.reset.projeto1.exception.PetNaoExistenteException;
import br.com.cwi.reset.projeto1.repository.PetRepository;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class PetService {

    private PetRepository repository;




    public Pet buscarPeloNome(String nome) {
        Pet pet = repository.buscarPeloNome(nome);

        if (pet == null) {
            throw new PetNaoExistenteException("Pet com o nome " + nome + " não existe.");
        }
        return pet;
    }

    public Pet salvar(Pet pet){
        Pet petJaCadastrado = repository.buscarPeloNome(pet.getNome());

        if (petJaCadastrado != null) {
            throw new PetJaExistenteException("Pet com o nome " + nome + " já existe.");
        }
        return repository;
    }
}

