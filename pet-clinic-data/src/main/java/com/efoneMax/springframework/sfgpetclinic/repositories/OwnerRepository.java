package com.efonemax.springframework.sfgpetclinic.repositories;

import com.efonemax.springframework.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
