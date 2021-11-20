package com.cheryomushkin.petclinic;

import com.cheryomushkin.petclinic.converters.Converter;
import com.cheryomushkin.petclinic.domain.Owner;
import com.cheryomushkin.petclinic.domain.Pet;
import com.cheryomushkin.petclinic.domain.PetType;
import com.cheryomushkin.petclinic.transport.OwnerDto;
import com.cheryomushkin.petclinic.transport.PetDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.OffsetDateTime;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ConverterTests {

    @Autowired
    Converter converter;

    @Test
    void contextLoads() {
    }

    @Test
    public void testOwnerMapping() {
        Owner owner = new Owner("Гарри", "Поттер", "ул. Тисовая 4", "Little Winging", "0");
        Pet pet =  new Pet(new PetType("OWL"), owner, OffsetDateTime.now());
        pet.setName("Букля");
        owner.getPets().add(pet);
        Iterable<OwnerDto> ownerDtos = converter.mapOwners(Collections.singletonList(owner));
        PetDto petDto = PetDto.builder().name(pet.getName()).build();
        OwnerDto ownerDto = OwnerDto.builder()
                        .firstName(owner.getFirstName()).lastName(owner.getLastName())
                        .address(owner.getAddress()).city(owner.getCity()).telephone(owner.getTelephone())
                        .pets(Collections.singletonList(petDto)).build();
        assertThat(ownerDtos).containsOnly(ownerDto);
    }
}
