package com.cheryomushkin.petclinic;

import com.cheryomushkin.petclinic.converter.Converter;
import com.cheryomushkin.petclinic.domain.Owner;
import com.cheryomushkin.petclinic.domain.Pet;
import com.cheryomushkin.petclinic.domain.PetType;
import com.cheryomushkin.petclinic.transport.PetDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class PetClinicApplicationTests {

    @Autowired
    Converter converter;

    @Test
    void contextLoads() {
    }

    @Test
    public void testMapping() {
        Owner owner = new Owner("a", "b");
        Pet pet =  Pet.builder().owner(owner).petType(PetType.CAT).birthday(LocalDate.now()).build();
        PetDto petDto = converter.mapPet(pet);
    }
}
