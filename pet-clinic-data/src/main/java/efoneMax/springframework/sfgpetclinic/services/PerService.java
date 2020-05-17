package efoneMax.springframework.sfgpetclinic.services;

import efoneMax.springframework.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PerService {
    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
