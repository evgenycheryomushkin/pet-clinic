package com.cheryomushkin.petclinic.transport.vets;

import com.cheryomushkin.petclinic.transport.UpdateSpecialtyDto;
import lombok.Value;

import java.util.List;

@Value
public class CreateVetDto {
    String firstName;
    String lastName;
    List<UpdateSpecialtyDto> specialties;
}
