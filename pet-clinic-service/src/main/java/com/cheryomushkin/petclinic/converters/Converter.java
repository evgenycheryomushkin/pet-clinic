package com.cheryomushkin.petclinic.converters;

import com.cheryomushkin.petclinic.domain.PetType;
import com.cheryomushkin.petclinic.domain.Specialty;
import com.cheryomushkin.petclinic.transport.PetTypeDto;
import com.cheryomushkin.petclinic.transport.SpecialtyDto;
import com.cheryomushkin.petclinic.transport.UpdateSpecialtyDto;

import java.util.List;

public interface Converter {
    PetTypeDto petTypeToPetTypeDto(PetType petType);
    Iterable<PetTypeDto> petTypesToPetTypeDtos(Iterable<PetType> petTypes);
    PetType petTypeDtoToPetType(PetTypeDto typeDto);
    List<SpecialtyDto> specialitiesToSpecialityDtos(Iterable<Specialty> specialities);
    SpecialtyDto specialityToSpecialityDto(Specialty specialty);
    List<Specialty> updateSpecialtyDtosToSpecialties(Iterable<UpdateSpecialtyDto> specialtyDtos);
    Specialty updateSpecialtyDtoToSpecialty(UpdateSpecialtyDto specialtyDto);
}
