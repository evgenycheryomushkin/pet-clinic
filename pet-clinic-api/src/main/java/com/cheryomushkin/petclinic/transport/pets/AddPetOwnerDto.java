package com.cheryomushkin.petclinic.transport.pets;

import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class AddPetOwnerDto {
    @NotNull Long id;
}
