package com.efonemax.sfgpetclinic.bootstrap;

import efoneMax.springframework.sfgpetclinic.map.OwnerServiceMap;
import efoneMax.springframework.sfgpetclinic.map.VetServiceMap;
import efoneMax.springframework.sfgpetclinic.model.Owner;
import efoneMax.springframework.sfgpetclinic.model.Vet;
import efoneMax.springframework.sfgpetclinic.services.OwnerService;
import efoneMax.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstname("OwnerFirstName1");
        owner1.setLastname("OwnerLastName1");
        owner1.setId(1L);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstname("OwnerFirstName2");
        owner2.setLastname("OwnerLastName2");
        owner2.setId(2L);

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstname("VetFirstName1");
        vet1.setLastname("VetLastName1");
        vet1.setId(1L);

        vetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setFirstname("VetFirstName2");
        vet2.setLastname("VetLastName2");
        vet2.setId(2L);

        vetService.save(vet2);


    }
}
