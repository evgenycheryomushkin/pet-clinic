package com.cheryomushkin.petclinic.transport.pets;

import com.cheryomushkin.petclinic.transport.PetTypeDto;
import com.cheryomushkin.petclinic.transport.owners.VisitDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;

import static com.cheryomushkin.petclinic.transport.Constants.DATE_FORMAT;

@Value
public class GetPetDto {
    Long id;
    String name;
    PetTypeDto type;
    @JsonFormat(pattern = DATE_FORMAT)
    LocalDate birthDate;
    GetPetOwnerDto owner;
    List<VisitDto> visits;
}
