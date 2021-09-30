package com.cheryomushkin.petclinic;

import com.cheryomushkin.petclinic.converter.Converter;
import com.cheryomushkin.petclinic.domain.Pet;
import com.cheryomushkin.petclinic.transport.PetDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PetClinicApplicationTests {

    @Autowired
    Converter converter;

    @Test
    void contextLoads() {
    }

    @Test
    public void testMapping() {
        Pet pet =  new Pet();
        PetDto petDto = converter.mapPet(pet);
    }

}
