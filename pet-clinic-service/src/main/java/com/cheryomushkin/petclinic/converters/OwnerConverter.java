package com.cheryomushkin.petclinic.converters;

import com.cheryomushkin.petclinic.domain.Owner;
import com.cheryomushkin.petclinic.transport.owners.AddOwnerDto;
import com.cheryomushkin.petclinic.transport.owners.GetOwnerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface OwnerConverter {
    GetOwnerDto mapOwnerGet(Owner owner);
    Iterable<GetOwnerDto> mapOwnersGet(Iterable<Owner> owners);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "pets", ignore = true)
    Owner mapAddOwnerDto(AddOwnerDto addOwnerDto);
}
