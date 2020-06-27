package com.efonemax.springframework.sfgpetclinic.bootstrap;

import com.efonemax.springframework.sfgpetclinic.model.Owner;
import com.efonemax.springframework.sfgpetclinic.model.Pet;
import com.efonemax.springframework.sfgpetclinic.model.PetType;
import com.efonemax.springframework.sfgpetclinic.model.Speciality;
import com.efonemax.springframework.sfgpetclinic.model.Vet;
import com.efonemax.springframework.sfgpetclinic.model.Visit;
import com.efonemax.springframework.sfgpetclinic.services.OwnerService;
import com.efonemax.springframework.sfgpetclinic.services.PetTypeService;
import com.efonemax.springframework.sfgpetclinic.services.SpecialtyService;
import com.efonemax.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    public void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("OwnerFirstName1");
        owner1.setLastName("OwnerLastName1");
        owner1.setAddress("Lakeshire road 5");
        owner1.setCity("City1");
        owner1.setTelephone("123123123");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("OwnerFirstName2");
        owner2.setLastName("OwnerLastName2");
        owner2.setAddress("Lakeshire road 6");
        owner2.setCity("City2");
        owner2.setTelephone("1231231231");

        Pet fionasCat = new Pet();
        fionasCat.setName("Just Cat");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setPetType(savedCatPetType);
        owner2.getPets().add(fionasCat);


        ownerService.save(owner2);

        Visit visit1 = new Visit();
        visit1.setPet(fionasCat);
        visit1.setDate(LocalDate.now());
        visit1.setDescription("Sneezy kitty");

        Vet vet1 = new Vet();
        vet1.setFirstName("VetFirstName1");
        vet1.setLastName("VetLastName1");

        vetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setFirstName("VetFirstName2");
        vet2.setLastName("VetLastName2");

        vetService.save(vet2);

        System.out.println(vet1);
        System.out.println(vet2);
        System.out.println(owner1);
        System.out.println(owner2);
    }
}
