package com.cheryomushkin.petclinic.transport.common;

import lombok.Value;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Value
public class CreateSpecialtyDto {
    @NotNull @NotEmpty String name;
}
