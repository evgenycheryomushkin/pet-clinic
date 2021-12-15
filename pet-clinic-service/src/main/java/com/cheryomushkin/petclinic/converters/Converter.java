package com.cheryomushkin.petclinic.converters;

import com.cheryomushkin.petclinic.domain.PetType;
import com.cheryomushkin.petclinic.domain.Specialty;
import com.cheryomushkin.petclinic.transport.common.CreatePetTypeDto;
import com.cheryomushkin.petclinic.transport.common.CreateSpecialtyDto;
import com.cheryomushkin.petclinic.transport.common.PetTypeDto;
import com.cheryomushkin.petclinic.transport.common.SpecialtyDto;
import com.cheryomushkin.petclinic.transport.common.UpdatePetTypeDto;
import com.cheryomushkin.petclinic.transport.common.UpdateSpecialtyDto;

import java.util.List;

public interface Converter {
    PetTypeDto petTypeToPetTypeDto(PetType petType);
    Iterable<PetTypeDto> petTypesToPetTypeDtos(Iterable<PetType> petTypes);
    PetType petTypeDtoToPetType(PetTypeDto typeDto);
    List<SpecialtyDto> specialitiesToSpecialityDtos(Iterable<Specialty> specialities);
    SpecialtyDto specialityToSpecialityDto(Specialty specialty);
    List<Specialty> updateSpecialtyDtosToSpecialties(Iterable<UpdateSpecialtyDto> specialtyDtos);
    Specialty updateSpecialtyDtoToSpecialty(UpdateSpecialtyDto specialtyDto);
    PetType updatePetTypeDtoToPetType(Long id, UpdatePetTypeDto updatePetTypeDto);
    PetType createPetTypeDtoToPetType(CreatePetTypeDto createPetTypeDto);
    Specialty updateSpecialtyDtoToSpecialty(Long id, UpdateSpecialtyDto updateSpecialtyDto);
    Specialty createSpecialtyDtoToSpecialty(CreateSpecialtyDto createSpecialtyDto);
}
