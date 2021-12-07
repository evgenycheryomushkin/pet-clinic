package com.cheryomushkin.petclinic.converters;

import com.cheryomushkin.petclinic.domain.Owner;
import com.cheryomushkin.petclinic.domain.Pet;
import com.cheryomushkin.petclinic.domain.Visit;
import com.cheryomushkin.petclinic.transport.visits.AddVisitDto;
import com.cheryomushkin.petclinic.transport.visits.GetVisitDto;
import com.cheryomushkin.petclinic.transport.visits.GetVisitPetDto;
import com.cheryomushkin.petclinic.transport.visits.UpdateVisitDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitsConverterImpl implements VisitsConverter {
    final PetsConverter petsConverter;
    final Converter converter;

    @Override
    public Visit addVisitDtoToVisit(AddVisitDto addVisitDto) {
        return new Visit(addVisitDto.getDate(), addVisitDto.getDescription(), addVisitDto.getPet().getId());
    }
    @Override
    public GetVisitDto visitToGetVisitDto(Visit visit, Pet pet, Owner owner) {
        return new GetVisitDto(visit.ensureId(), visit.getDescription(), visit.getDate(), petToGetVisitPetDto(pet, owner));
    }
    @Override
    public GetVisitPetDto petToGetVisitPetDto(Pet pet, Owner owner) {
        return new GetVisitPetDto(pet.ensureId(), pet.getName(), pet.getBirthDate(), converter.petTypeToPetTypeDto(pet.getType()),
                petsConverter.ownerToGetPetOwnerDto(owner));
    }
    @Override
    public Visit updateVisitDtoToVisit(Long id, UpdateVisitDto updateVisitDto) {
        Visit visit = new Visit(updateVisitDto.getDate(), updateVisitDto.getDescription(), updateVisitDto.getPet().getId());
        visit.setId(id);
        return visit;
    }
}
