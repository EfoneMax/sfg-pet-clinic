package com.efonemax.springframework.sfgpetclinic.repositories;

import com.efonemax.springframework.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastname(String lastName);

    List<Owner> findAllByLastnameLike(String lastName);
}
