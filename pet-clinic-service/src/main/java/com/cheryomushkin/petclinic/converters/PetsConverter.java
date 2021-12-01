package com.cheryomushkin.petclinic.converters;

import com.cheryomushkin.petclinic.domain.Owner;
import com.cheryomushkin.petclinic.domain.Pet;
import com.cheryomushkin.petclinic.transport.pets.AddPetDto;
import com.cheryomushkin.petclinic.transport.pets.GetPetDto;
import com.cheryomushkin.petclinic.transport.pets.GetPetOwnerDto;
import com.cheryomushkin.petclinic.transport.pets.UpdatePetDto;

public interface PetsConverter {
    GetPetOwnerDto ownerToGetPetOwnerDto(Owner owner);

    GetPetDto petAndOwnerToGetPetDto(Pet pet, Owner owner);
    Pet updatePetDtoAndIdToPet(UpdatePetDto updatePetDto, Long id);
    Pet addPetDtoAndOwnerIdToPet(AddPetDto addPetDto, Long ownerId);
}
