package com.efonemax.springframework.sfgpetclinic.services.springdatajpa;

import com.efonemax.springframework.sfgpetclinic.model.Vet;
import com.efonemax.springframework.sfgpetclinic.repositories.VetRepository;
import com.efonemax.springframework.sfgpetclinic.services.VetService;
import com.sun.istack.Nullable;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetsSDJpaService implements VetService {
    private final VetRepository vetRepository;

    public VetsSDJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vetSet = new HashSet<>();
        vetRepository.findAll().forEach(vetSet::add);
        return vetSet;
    }

    @Override
    @Nullable
    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
