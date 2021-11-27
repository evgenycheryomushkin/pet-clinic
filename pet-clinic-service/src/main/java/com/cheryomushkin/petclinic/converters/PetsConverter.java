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
public interface PetsConverter {
    Iterable<PetTypeDto> mapPetTypes(Iterable<PetType> petTypes);

    @Mapping(target = "id", source = "pet.id")
    GetPetDto mapPet(Pet pet, Owner owner);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ownerId", source = "owner.id")
    @Mapping(target = "visits", ignore = true)
    Pet mapUpdatePetDto(UpdatePetDto updatePetDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "addPetDto.petName")
    @Mapping(target = "visits", ignore = true)
    Pet mapAddPetDto(AddPetDto addPetDto, Long ownerId);
}
