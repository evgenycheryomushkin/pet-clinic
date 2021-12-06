package com.cheryomushkin.petclinic.transport.owners;

import lombok.Value;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Value
public class AddOwnerDto {
    @NotNull @NotEmpty String firstName;
    @NotNull @NotEmpty String lastName;
    @NotNull @NotEmpty String address;
    @NotNull @NotEmpty String city;
    @NotNull @NotEmpty String telephone;
}
