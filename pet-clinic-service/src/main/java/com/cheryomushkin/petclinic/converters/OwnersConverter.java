package com.cheryomushkin.petclinic.converters;

import com.cheryomushkin.petclinic.domain.Owner;
import com.cheryomushkin.petclinic.domain.Pet;
import com.cheryomushkin.petclinic.transport.owners.AddOwnerDto;
import com.cheryomushkin.petclinic.transport.owners.GetOwnerDto;
import com.cheryomushkin.petclinic.transport.owners.GetOwnerPetDto;

public interface OwnersConverter {
    GetOwnerPetDto petToGetOwnerPetDto(Pet pet);

    GetOwnerDto ownerToGetOwnerDto(Owner owner);
    Iterable<GetOwnerDto> ownersToGetOwnerDtos(Iterable<Owner> owners);
    Owner addOwnerDtoToOwner(AddOwnerDto addOwnerDto);
    Owner addOwnerDtoIdToOwner(AddOwnerDto addOwnerDto, Long id);
}
