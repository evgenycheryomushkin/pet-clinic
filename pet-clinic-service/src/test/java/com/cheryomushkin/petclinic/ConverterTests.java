package com.cheryomushkin.petclinic;

import com.cheryomushkin.petclinic.converters.PetConverter;
import com.cheryomushkin.petclinic.domain.Pet;
import com.cheryomushkin.petclinic.transport.pets.AddPetOwnerDto;
import com.cheryomushkin.petclinic.transport.pets.PetTypeDto;
import com.cheryomushkin.petclinic.transport.pets.UpdatePetDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
public class ConverterTests {
    @Autowired
    PetConverter petConverter;
    @Test
    public void testUpdatePetDto() {
        UpdatePetDto updatePetDto = UpdatePetDto.builder()
                .name("Pet")
                .birthDate(LocalDate.now())
                .owner(AddPetOwnerDto.builder().id(1L).build())
                .type(PetTypeDto.builder().id(3L).name("Owl").build())
                .build();
        Pet pet = petConverter.mapUpdatePetDto(updatePetDto);
        assertEquals(updatePetDto.getName(), pet.getName());
        assertEquals(updatePetDto.getBirthDate(), pet.getBirthDate());
        assertEquals(updatePetDto.getOwner().getId(), pet.getOwnerId());
        assertEquals(updatePetDto.getType().getId(), pet.getType().getId());
        assertEquals(updatePetDto.getType().getName(), pet.getType().getName());
    }
}
