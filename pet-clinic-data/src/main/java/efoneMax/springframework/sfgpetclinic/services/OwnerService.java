package efoneMax.springframework.sfgpetclinic.services;

import efoneMax.springframework.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
