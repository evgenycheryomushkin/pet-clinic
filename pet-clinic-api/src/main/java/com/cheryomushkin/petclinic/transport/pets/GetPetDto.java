package com.cheryomushkin.petclinic.transport.pets;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

@Builder
@Value
@Jacksonized
public class GetPetDto {
    Long id;
    String name;
    PetTypeDto type;
    @JsonFormat(pattern = "yyyy/MM/dd") //todo move to config
    LocalDate birthDate;
    GetPetOwnerDto owner;
}
