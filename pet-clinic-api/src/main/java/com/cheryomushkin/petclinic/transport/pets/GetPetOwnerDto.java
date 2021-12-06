package com.cheryomushkin.petclinic.transport.pets;

import lombok.Value;

@Value
public class GetPetOwnerDto {
    Long id;
    String firstName;
    String lastName;
}
