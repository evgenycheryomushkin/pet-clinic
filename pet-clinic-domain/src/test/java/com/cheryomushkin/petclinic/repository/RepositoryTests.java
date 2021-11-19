package com.cheryomushkin.petclinic.repository;

import com.cheryomushkin.petclinic.domain.Owner;
import com.cheryomushkin.petclinic.domain.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class RepositoryTests {
    @Autowired
    OwnerRepository ownerRepository;
    @Autowired
    PetRepository petRepository;
    @Autowired
    PetTypeRepository petTypeRepository;

    private Long ownerId;
    private Long sowaId;

    @BeforeEach
    public void beforeEach() {
        Owner o = new Owner(
                "Гарри",
                "Поттер",
                "ул. Тисовая, 4",
                "Little Whinging",
                "0");
        Pet sowa = new Pet(
                petTypeRepository.findFirstByName("OWL"), o, OffsetDateTime.parse("1989-01-03T00:00:00+01:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        sowa.setName("Букля");
        o.getPets().add(sowa);
        ownerId = ownerRepository.save(o).getId();
        sowaId = petRepository.save(sowa).getId();
    }

    @Test
    public void testCreatePet() {
        Optional<Pet> sowa = petRepository.findById(sowaId);
        assertTrue(sowa.isPresent());
        assertEquals("Букля", sowa.get().getName());
        assertEquals(petTypeRepository.findFirstByName("OWL"), sowa.get().getPetType());
    }

    @Test
    public void testCreateOwner() {
        Optional<Owner> owner = ownerRepository.findById(ownerId);
        assertTrue(owner.isPresent());
        assertEquals("Гарри", owner.get().getFirstName());
        assertEquals("Поттер", owner.get().getLastName());
    }
}
