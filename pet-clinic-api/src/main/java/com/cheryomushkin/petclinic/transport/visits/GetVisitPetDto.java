package com.cheryomushkin.petclinic.transport.visits;

import com.cheryomushkin.petclinic.transport.common.PetTypeDto;
import com.cheryomushkin.petclinic.transport.pets.GetPetOwnerDto;
import lombok.Value;

import java.time.LocalDate;

@Value
public class GetVisitPetDto {
    Long id;
    String name;
    LocalDate birthDate;
    PetTypeDto type;
    GetPetOwnerDto owner;
}
