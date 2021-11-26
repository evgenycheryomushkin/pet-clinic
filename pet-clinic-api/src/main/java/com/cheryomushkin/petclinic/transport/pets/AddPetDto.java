package com.cheryomushkin.petclinic.transport.pets;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

import static com.cheryomushkin.petclinic.transport.Constants.DATE_FORMAT;

@Builder
@Value
@Jacksonized
public class AddPetDto {
    @NotNull @NotEmpty
    String petName;
    @NotNull
    PetTypeDto type;
    @NotNull
    @JsonFormat(pattern = DATE_FORMAT)
    LocalDate birthDate;
    @NotNull
    AddPetOwnerDto owner;
}
