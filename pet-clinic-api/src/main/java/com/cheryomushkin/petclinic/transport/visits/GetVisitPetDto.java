package com.cheryomushkin.petclinic.transport.visits;

import com.cheryomushkin.petclinic.transport.PetTypeDto;
import com.cheryomushkin.petclinic.transport.pets.GetPetOwnerDto;
import lombok.Value;

import java.time.LocalDate;

@Value
public class GetVisitPetDto {
    String name;
    LocalDate birthDate;
    PetTypeDto type;
    GetPetOwnerDto owner;
}
