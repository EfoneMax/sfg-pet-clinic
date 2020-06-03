package com.efoneMax.springframework.sfgpetclinic.services;

import com.efoneMax.springframework.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
