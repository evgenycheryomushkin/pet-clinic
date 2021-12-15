package com.cheryomushkin.petclinic.transport.common;

import lombok.Value;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Value
public class CreatePetTypeDto {
    @NotNull @NotEmpty String name;
}
