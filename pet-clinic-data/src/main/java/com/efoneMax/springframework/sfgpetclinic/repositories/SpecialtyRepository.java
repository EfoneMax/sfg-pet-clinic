package com.efonemax.springframework.sfgpetclinic.repositories;

import com.efonemax.springframework.sfgpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Speciality, Long > {
}
