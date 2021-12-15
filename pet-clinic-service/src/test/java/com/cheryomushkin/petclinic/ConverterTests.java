package com.cheryomushkin.petclinic;

import com.cheryomushkin.petclinic.converters.PetsConverter;
import com.cheryomushkin.petclinic.domain.Pet;
import com.cheryomushkin.petclinic.transport.common.PetTypeDto;
import com.cheryomushkin.petclinic.transport.pets.AddPetOwnerDto;
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
    final PetsConverter petsConverter;

    @Autowired
    public ConverterTests(PetsConverter petsConverter) {
        this.petsConverter = petsConverter;
    }

    @Test
    public void testUpdatePetDto() {
        UpdatePetDto updatePetDto = new UpdatePetDto(
                "Pet", LocalDate.now(),
                new PetTypeDto(1L, "OWL"), new AddPetOwnerDto(1L));
        Pet pet = petsConverter.updatePetDtoAndIdToPet(10L, updatePetDto);
        assertEquals(10L, pet.ensureId());
        assertEquals(updatePetDto.getName(), pet.getName());
        assertEquals(updatePetDto.getBirthDate(), pet.getBirthDate());
        assertEquals(updatePetDto.getOwner().getId(), pet.getOwnerId());
        assertEquals(updatePetDto.getType().getId(), pet.getType().ensureId());
        assertEquals(updatePetDto.getType().getName(), pet.getType().getName());
    }
}
