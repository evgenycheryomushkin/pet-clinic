package com.cheryomushkin.petclinic.transport.owners;

import lombok.Value;

import java.util.List;

@Value
public class GetOwnerDto {
    Long id;
    String firstName;
    String lastName;
    String address;
    String city;
    String telephone;
    List<GetOwnerPetDto> pets;
}
