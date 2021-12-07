package com.cheryomushkin.petclinic.converters;

import com.cheryomushkin.petclinic.domain.Owner;
import com.cheryomushkin.petclinic.domain.Pet;
import com.cheryomushkin.petclinic.domain.Visit;
import com.cheryomushkin.petclinic.transport.visits.AddVisitDto;
import com.cheryomushkin.petclinic.transport.visits.GetVisitDto;
import com.cheryomushkin.petclinic.transport.visits.GetVisitPetDto;
import com.cheryomushkin.petclinic.transport.visits.UpdateVisitDto;

public interface VisitsConverter {
    Visit addVisitDtoToVisit(AddVisitDto addVisitDto);
    GetVisitDto visitToGetVisitDto(Visit visit, Pet pet, Owner owner);
    GetVisitPetDto petToGetVisitPetDto(Pet pet, Owner owner);
    Visit updateVisitDtoToVisit(Long id, UpdateVisitDto updateVisitDto);
}
