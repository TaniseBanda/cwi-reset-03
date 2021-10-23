package br.com.cwi.reset.projeto1.controller;

import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    private PetService petService = new PetService();

    @GetMapping
    public List<Pet> consultarPets() {
        return petService.listarPets();
    }

    @GetMapping("/{nome}")
    public ResponseEntity buscarPetPeloNome(@PathVariable String nome) {
        try {
            return petService.buscarPorNome(nome);
        } catch (PetNãoExistenteException e) {
            return ResponseEntity.badRequest().build();
        }








    private Pet buscarPetPeloNome(String nome) {
        for (Pet pet : pets) {
            if (pet.getNome().equals(nome)) {
                return pet;
            }
        }
        return null;
    }

    @PostMapping
    public Pet cadastrarPet(@RequestBody Pet pet) {
        pets.add(pet);
        return pet;
    }

    @PutMapping
    public void atualizarPet(@RequestBody Pet pet) {
        Pet petCadastrado = buscarPetPeloNome(pet.getNome());

        if (petCadastrado != null) {
            pets.remove(petCadastrado);
            pets.add(pet);
        }
    }

    @DeleteMapping("/{nome}")
    public void deletarPet(@PathVariable String nome) {
        Pet pet = buscarPetPeloNome(nome);
        if (pet != null) {
            pets.remove(pet);
        }
    }

}
