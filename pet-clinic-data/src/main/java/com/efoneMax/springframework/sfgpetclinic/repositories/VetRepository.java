package com.efonemax.springframework.sfgpetclinic.repositories;

import com.efonemax.springframework.sfgpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
