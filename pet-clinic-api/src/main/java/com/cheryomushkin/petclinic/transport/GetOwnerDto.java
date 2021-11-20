package com.cheryomushkin.petclinic.transport;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Builder
@Value
@Jacksonized
public class GetOwnerDto {
    Long id;
    String firstName;
    String lastName;
    String address;
    String city;
    String telephone;
    List<GetOwnerPetDto> pets;
}
