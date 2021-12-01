package com.cheryomushkin.petclinic.transport.visits;

import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class PetIdDto {
    @NotNull
    Long id;
}
