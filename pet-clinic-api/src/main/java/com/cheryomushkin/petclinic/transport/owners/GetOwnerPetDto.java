package com.cheryomushkin.petclinic.transport.owners;

import com.cheryomushkin.petclinic.transport.common.PetTypeDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;

import static com.cheryomushkin.petclinic.transport.Constants.DATE_FORMAT;

@Value
public class GetOwnerPetDto {
    Long id;
    String name;
    PetTypeDto type;
    @JsonFormat(pattern = DATE_FORMAT)
    LocalDate birthDate;
    List<VisitDto> visits;
}
