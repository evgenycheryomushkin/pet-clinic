package com.cheryomushkin.petclinic.transport.pets;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class GetPetOwnerDto {
    Long id;
    String firstName;
    String lastName;
}
