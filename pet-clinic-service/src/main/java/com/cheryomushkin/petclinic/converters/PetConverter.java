package com.cheryomushkin.petclinic.converters;

import com.cheryomushkin.petclinic.domain.Owner;
import com.cheryomushkin.petclinic.domain.Pet;
import com.cheryomushkin.petclinic.domain.PetType;
import com.cheryomushkin.petclinic.transport.pets.AddPetDto;
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
    Pet mapUpdatePetDto(UpdatePetDto updatePetDto, Owner owner);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "addPetDto.petName")
    @Mapping(target = "owner", source = "owner")
    Pet mapAddPetDto(AddPetDto addPetDto, Owner owner);
}
