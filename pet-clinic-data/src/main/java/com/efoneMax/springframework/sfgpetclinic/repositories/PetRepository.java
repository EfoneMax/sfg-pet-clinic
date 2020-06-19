package com.efonemax.springframework.sfgpetclinic.repositories;

import com.efonemax.springframework.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
