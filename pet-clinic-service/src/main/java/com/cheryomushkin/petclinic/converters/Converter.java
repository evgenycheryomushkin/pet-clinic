package com.cheryomushkin.petclinic.converters;

import com.cheryomushkin.petclinic.domain.Owner;
import com.cheryomushkin.petclinic.domain.Pet;
import com.cheryomushkin.petclinic.transport.OwnerDto;
import com.cheryomushkin.petclinic.transport.PetDto;
import org.mapstruct.Mapper;

@Mapper
public interface Converter {
    PetDto mapPet(Pet pet);
    OwnerDto mapOwner(Owner owner);
    Iterable<OwnerDto> mapOwners(Iterable<Owner> owners);
}
