package com.cheryomushkin.petclinic.transport.vets;

import com.cheryomushkin.petclinic.transport.common.SpecialtyDto;
import lombok.Value;

import java.util.List;

@Value
public class GetVetDto {
    Long id;
    String firstName;
    String lastName;
    List<SpecialtyDto> specialties;
}
