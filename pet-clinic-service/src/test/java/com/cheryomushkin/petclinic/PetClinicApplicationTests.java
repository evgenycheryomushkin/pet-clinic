package com.cheryomushkin.petclinic;

import com.cheryomushkin.petclinic.converters.Converter;
import com.cheryomushkin.petclinic.domain.Owner;
import com.cheryomushkin.petclinic.domain.Pet;
import com.cheryomushkin.petclinic.domain.PetType;
import com.cheryomushkin.petclinic.transport.PetDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.OffsetDateTime;

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
        Pet pet =  new Pet(new PetType("OWL"), owner, OffsetDateTime.now());
        PetDto petDto = converter.mapPet(pet);
    }
}
