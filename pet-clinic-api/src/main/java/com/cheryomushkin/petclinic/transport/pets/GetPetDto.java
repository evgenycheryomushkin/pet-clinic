package com.cheryomushkin.petclinic.transport.pets;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

import static com.cheryomushkin.petclinic.transport.Constants.DATE_FORMAT;

@Builder
@Value
@Jacksonized
public class GetPetDto {
    Long id;
    String name;
    PetTypeDto type;
    @JsonFormat(pattern = DATE_FORMAT)
    LocalDate birthDate;
    GetPetOwnerDto owner;
}
