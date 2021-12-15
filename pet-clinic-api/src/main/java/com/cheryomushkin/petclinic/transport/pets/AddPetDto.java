package com.cheryomushkin.petclinic.transport.pets;

import com.cheryomushkin.petclinic.transport.common.PetTypeDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Value;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

import static com.cheryomushkin.petclinic.transport.Constants.DATE_FORMAT;

@Value
public class AddPetDto {
    @NotNull @NotEmpty String petName;
    @NotNull PetTypeDto type;
    @JsonFormat(pattern = DATE_FORMAT)
    @NotNull LocalDate birthDate;
    @NotNull AddPetOwnerDto owner;
}
