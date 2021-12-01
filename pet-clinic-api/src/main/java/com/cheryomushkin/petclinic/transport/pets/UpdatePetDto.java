package com.cheryomushkin.petclinic.transport.pets;

import com.cheryomushkin.petclinic.transport.PetTypeDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Value;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

import static com.cheryomushkin.petclinic.transport.Constants.DATE_FORMAT;

@Value
public class UpdatePetDto {
    @NotNull @NotEmpty String name;
    @JsonFormat(pattern = DATE_FORMAT)
    @NotNull LocalDate birthDate;
    @NotNull PetTypeDto type;
    @NotNull AddPetOwnerDto owner;
}
