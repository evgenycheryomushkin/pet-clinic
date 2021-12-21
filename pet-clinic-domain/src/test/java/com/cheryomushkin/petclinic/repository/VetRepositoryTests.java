package com.cheryomushkin.petclinic.repository;

import com.cheryomushkin.petclinic.domain.Specialty;
import com.cheryomushkin.petclinic.domain.Vet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class VetRepositoryTests {
    final VetRepository vetRepository;
    final SpecialtyRepository specialtyRepository;

    @Autowired
    public VetRepositoryTests(VetRepository vetRepository, SpecialtyRepository specialtyRepository) {
        this.vetRepository = vetRepository;
        this.specialtyRepository = specialtyRepository;
    }

    @Test
    public void test() {
        Specialty specialty = new Specialty("Крупные животные");
        specialty = specialtyRepository.save(specialty);
        Vet vet = new Vet("Рубиус", "Хагрид", Collections.singletonList(specialty));
        vet = vetRepository.save(vet);
        Optional<Vet> vet2 = vetRepository.findById(vet.ensureId());
        assertTrue(vet2.isPresent());
        assertEquals(vet2.get().getFirstName(), vet.getFirstName());
        assertEquals(vet2.get().getLastName(), vet.getLastName());
        assertEquals(vet2.get().getSpecialties().size(), vet.getSpecialties().size());
        assertEquals(vet2.get().getSpecialties().get(0).getName(), vet.getSpecialties().get(0).getName());
    }
}
