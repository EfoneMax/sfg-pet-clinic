package com.efonemax.springframework.sfgpetclinic.services.map;

import com.efonemax.springframework.sfgpetclinic.model.Owner;
import com.efonemax.springframework.sfgpetclinic.model.Pet;
import com.efonemax.springframework.sfgpetclinic.model.PetType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    private OwnerMapService ownerMapService;

    private static final long ownerId = 1L;

    private static final String lastName = "Smith";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        MockitoAnnotations.initMocks(this);

        PetType petTypePacMan = PetType.builder()
                .name("Packman")
                .build();
        Pet petPacMan = Pet.builder()
                .petType(petTypePacMan)
                .build();
        Owner owner = Owner.builder()
                .id(ownerId)
                .pets(Stream.of(petPacMan).collect(Collectors.toCollection(HashSet::new)))
                .lastName(lastName)
                .build();

        ownerMapService.save(owner);
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveExistingId() {
        long id = 2L;
        Owner owner = Owner.builder().id(id).pets(new HashSet<Pet>()).build();
        Owner savedOwner = ownerMapService.save(owner);

        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner savedOwner = Owner.builder().build();
        ownerMapService.save(savedOwner);

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(Owner.builder().id(ownerId).build());
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName(lastName);
        assertNotNull(owner);
        assertEquals(lastName, owner.getLastName());
    }
}