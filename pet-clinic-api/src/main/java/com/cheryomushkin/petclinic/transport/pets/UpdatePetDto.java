package com.cheryomushkin.petclinic.transport.pets;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Builder
@Value
@Jacksonized
public class UpdatePetDto {
    @NotNull @NotEmpty
    String name;
    @NotNull
    @JsonFormat(pattern = "yyyy/MM/dd")
    LocalDate birthDate;
    @NotNull
    PetTypeDto type;
    @NotNull
    AddPetOwnerDto owner;
}
