package com.efonemax.springframework.sfgpetclinic.services;

import com.efonemax.springframework.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
