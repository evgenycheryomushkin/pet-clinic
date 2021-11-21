package com.cheryomushkin.petclinic.transport.owners;

import com.cheryomushkin.petclinic.transport.pets.PetTypeDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

@Builder
@Value
@Jacksonized
public class GetOwnerPetDto {
    Long id;
    String name;
    PetTypeDto type;
    @JsonFormat(pattern = "yyyy/MM/dd")
    LocalDate birthDate;
}
