package com.cheryomushkin.petclinic.converters;

import com.cheryomushkin.petclinic.domain.Owner;
import com.cheryomushkin.petclinic.domain.Pet;
import com.cheryomushkin.petclinic.domain.Visit;
import com.cheryomushkin.petclinic.transport.owners.AddOwnerDto;
import com.cheryomushkin.petclinic.transport.owners.GetOwnerDto;
import com.cheryomushkin.petclinic.transport.owners.GetOwnerPetDto;
import com.cheryomushkin.petclinic.transport.owners.VisitDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
                pet.getBirthDate(), visitsToVisitDtos(pet.getVisits()));
    }

    @Override
    public List<VisitDto> visitsToVisitDtos(List<Visit> visits) {
        return visits.stream().map(this::visitToVisitDto).collect(Collectors.toList());
    }

    @Override
    public VisitDto visitToVisitDto(Visit visit) {
        return new VisitDto(visit.ensureId(), visit.getDate(), visit.getDescription());
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
                addOwnerDto.getAddress(), addOwnerDto.getCity(), addOwnerDto.getTelephone(),
                new ArrayList<>());
    }

    @Override
    public Owner addOwnerDtoIdToOwner(Long id, AddOwnerDto addOwnerDto) {
        Owner owner = new Owner(addOwnerDto.getFirstName(), addOwnerDto.getLastName(),
                addOwnerDto.getAddress(), addOwnerDto.getCity(), addOwnerDto.getTelephone(),
                new ArrayList<>());
        owner.setId(id);
        return owner;
    }
}
