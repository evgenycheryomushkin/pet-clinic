package com.cheryomushkin.petclinic.repository;

import com.cheryomushkin.petclinic.domain.Owner;
import com.cheryomushkin.petclinic.domain.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class OwnerRepositoryTests {
    final OwnerRepository ownerRepository;
    final PetRepository petRepository;
    final PetTypeRepository petTypeRepository;

    private Long ownerId = 0L;
    private Long sowaId = 0L;

    @Autowired
    public OwnerRepositoryTests(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @BeforeEach
    public void beforeEach() {
        Owner o = new Owner(
                "Гарри",
                "Поттер",
                "ул. Тисовая, 4",
                "Little Whinging",
                "0",
                new ArrayList<>());
        o = ownerRepository.save(o);
        ownerId = o.ensureId();
        Pet sowa = new Pet(
                "Букля",
                petTypeRepository.findFirstByName("Сова"),
                ownerId,
                LocalDate.now(),
                new ArrayList<>());
        sowa = petRepository.save(sowa);
        sowaId = sowa.ensureId();
        o.getPets().add(sowa);
        ownerRepository.save(o);
    }

    @Test
    public void testCreatePet() {
        Optional<Pet> sowa = petRepository.findById(sowaId);
        assertTrue(sowa.isPresent());
        assertEquals("Букля", sowa.get().getName());
        assertEquals(petTypeRepository.findFirstByName("Сова"), sowa.get().getType());
    }

    @Test
    public void testCreateOwner() {
        Optional<Owner> owner = ownerRepository.findById(ownerId);
        assertTrue(owner.isPresent());
        assertEquals("Гарри", owner.get().getFirstName());
        assertEquals("Поттер", owner.get().getLastName());
    }
}
