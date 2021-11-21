package com.cheryomushkin.petclinic.transport.owners;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@Value
@Jacksonized
public class AddOwnerDto {
    @NotNull @NotEmpty
    String firstName;
    @NotNull @NotEmpty
    String lastName;
    @NotNull @NotEmpty
    String address;
    @NotNull @NotEmpty
    String city;
    @NotNull @NotEmpty
    String telephone;
}
