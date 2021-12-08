package com.cheryomushkin.petclinic.transport;

import lombok.Value;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Value
public class UpdateSpecialtyDto {
    @NotNull Long id;
    @NotNull @NotEmpty String name;
}
