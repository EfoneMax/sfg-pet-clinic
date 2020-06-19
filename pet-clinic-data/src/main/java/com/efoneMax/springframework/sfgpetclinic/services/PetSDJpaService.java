package com.efonemax.springframework.sfgpetclinic.services;

import com.efonemax.springframework.sfgpetclinic.model.Pet;
import com.efonemax.springframework.sfgpetclinic.repositories.OwnerRepository;
import com.efonemax.springframework.sfgpetclinic.repositories.PetRepository;
import com.efonemax.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService  {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public PetSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository,
                             PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }


    @Override
    public Set<Pet> findAll() {
        Set<Pet> petSet = new HashSet<>();
        ownerRepository.findAll().forEach(petSet::add);
        return petSet;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }
}
