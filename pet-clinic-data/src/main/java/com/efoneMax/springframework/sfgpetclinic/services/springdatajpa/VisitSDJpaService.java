package com.efonemax.springframework.sfgpetclinic.services.springdatajpa;

import com.efonemax.springframework.sfgpetclinic.model.Visit;
import com.efonemax.springframework.sfgpetclinic.repositories.VetRepository;
import com.efonemax.springframework.sfgpetclinic.repositories.VisitRepository;
import com.efonemax.springframework.sfgpetclinic.services.VisitService;
import com.sun.istack.Nullable;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {
    private final VisitRepository visitRepository;

    public VisitSDJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> vetSet = new HashSet<>();
        visitRepository.findAll().forEach(vetSet::add);
        return vetSet;
    }

    @Override
    @Nullable
    public Visit findById(Long aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        visitRepository.deleteById(aLong);
    }
}
