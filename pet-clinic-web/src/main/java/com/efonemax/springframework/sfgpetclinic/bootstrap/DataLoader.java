package com.efonemax.springframework.sfgpetclinic.bootstrap;

import com.efonemax.springframework.sfgpetclinic.model.Owner;
import com.efonemax.springframework.sfgpetclinic.model.PetType;
import com.efonemax.springframework.sfgpetclinic.model.Vet;
import com.efonemax.springframework.sfgpetclinic.services.OwnerService;
import com.efonemax.springframework.sfgpetclinic.services.PetTypeService;
import com.efonemax.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstname("OwnerFirstName1");
        owner1.setLastname("OwnerLastName1");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstname("OwnerFirstName2");
        owner2.setLastname("OwnerLastName2");

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstname("VetFirstName1");
        vet1.setLastname("VetLastName1");

        vetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setFirstname("VetFirstName2");
        vet2.setLastname("VetLastName2");

        vetService.save(vet2);

        System.out.println(vet1);
        System.out.println(vet2);
        System.out.println(owner1);
        System.out.println(owner2);


    }
}
