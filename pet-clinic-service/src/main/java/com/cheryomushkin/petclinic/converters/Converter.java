package com.cheryomushkin.petclinic.converters;

import com.cheryomushkin.petclinic.domain.Owner;
import com.cheryomushkin.petclinic.domain.Pet;
import com.cheryomushkin.petclinic.domain.Vet;
import com.cheryomushkin.petclinic.transport.OwnerDto;
import com.cheryomushkin.petclinic.transport.PetDto;
import com.cheryomushkin.petclinic.transport.VetDto;
import org.mapstruct.Mapper;

@Mapper
public interface Converter {
    PetDto mapPet(Pet pet);
    Iterable<OwnerDto> mapOwners(Iterable<Owner> owners);
    Iterable<VetDto> mapVets(Iterable<Vet> vets);

    OwnerDto mapOwner(Owner owner);
}
