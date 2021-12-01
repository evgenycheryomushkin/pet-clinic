package com.cheryomushkin.petclinic.converters;

import com.cheryomushkin.petclinic.domain.Owner;
import com.cheryomushkin.petclinic.domain.Pet;
import com.cheryomushkin.petclinic.transport.owners.AddOwnerDto;
import com.cheryomushkin.petclinic.transport.owners.GetOwnerDto;
import com.cheryomushkin.petclinic.transport.owners.GetOwnerPetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class OwnersConverterImpl implements OwnersConverter {
    final Converter converter;
    @Override
    public GetOwnerPetDto petToGetOwnerPetDto(Pet pet) {
        return new GetOwnerPetDto(
                pet.ensureId(), pet.getName(), converter.petTypeToPetTypeDto(pet.getType()),
                pet.getBirthDate());
    }
    @Override
    public GetOwnerDto ownerToGetOwnerDto(Owner owner) {
        return new GetOwnerDto(
                owner.ensureId(), owner.getFirstName(), owner.getLastName(),
                owner.getAddress(), owner.getCity(), owner.getTelephone(),
                owner.getPets().stream().map(this::petToGetOwnerPetDto).collect(Collectors.toList()));
    }

    @Override
    public Iterable<GetOwnerDto> ownersToGetOwnerDtos(Iterable<Owner> owners) {
        return StreamSupport.stream(owners.spliterator(), false)
                .map(this::ownerToGetOwnerDto).collect(Collectors.toList());
    }

    @Override
    public Owner addOwnerDtoToOwner(AddOwnerDto addOwnerDto) {
        return new Owner(addOwnerDto.getFirstName(), addOwnerDto.getLastName(),
                addOwnerDto.getAddress(), addOwnerDto.getCity(), addOwnerDto.getTelephone());
    }

    @Override
    public Owner addOwnerDtoIdToOwner(AddOwnerDto addOwnerDto, Long id) {
        Owner owner = new Owner(addOwnerDto.getFirstName(), addOwnerDto.getLastName(),
                addOwnerDto.getAddress(), addOwnerDto.getCity(), addOwnerDto.getTelephone());
        owner.setId(id);
        return owner;
    }
}
