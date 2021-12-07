package com.cheryomushkin.petclinic.converters;

import com.cheryomushkin.petclinic.domain.Owner;
import com.cheryomushkin.petclinic.domain.Pet;
import com.cheryomushkin.petclinic.domain.Visit;
import com.cheryomushkin.petclinic.transport.owners.AddOwnerDto;
import com.cheryomushkin.petclinic.transport.owners.GetOwnerDto;
import com.cheryomushkin.petclinic.transport.owners.GetOwnerPetDto;
import com.cheryomushkin.petclinic.transport.owners.VisitDto;

import java.util.List;

public interface OwnersConverter {
    GetOwnerPetDto petToGetOwnerPetDto(Pet pet);
    List<VisitDto> visitsToVisitDtos(List<Visit> visits);
    VisitDto visitToVisitDto(Visit visit);
    GetOwnerDto ownerToGetOwnerDto(Owner owner);
    Iterable<GetOwnerDto> ownersToGetOwnerDtos(Iterable<Owner> owners);
    Owner addOwnerDtoToOwner(AddOwnerDto addOwnerDto);
    Owner addOwnerDtoIdToOwner(Long id, AddOwnerDto addOwnerDto);
}
