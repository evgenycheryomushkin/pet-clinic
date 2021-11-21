package com.cheryomushkin.petclinic.converters;

import com.cheryomushkin.petclinic.domain.Owner;
import com.cheryomushkin.petclinic.domain.Pet;
import com.cheryomushkin.petclinic.domain.PetType;
import com.cheryomushkin.petclinic.transport.pets.GetPetDto;
import com.cheryomushkin.petclinic.transport.pets.PetTypeDto;
import com.cheryomushkin.petclinic.transport.pets.UpdatePetDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PetConverter {
    Iterable<PetTypeDto> mapPetTypes(Iterable<PetType> petTypes);
    GetPetDto mapPet(Pet pet);

    @Mapping(target = "id", ignore = true)
    Pet mapAddPetDto(UpdatePetDto updatePetDto, Owner owner);
}
