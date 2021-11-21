package com.cheryomushkin.petclinic.transport.pets;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@Value
@Jacksonized
public class PetTypeDto {
    @NotNull
    Long id;
    @NotNull @NotEmpty
    String name;
}
