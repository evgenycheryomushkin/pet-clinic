package com.cheryomushkin.petclinic.controllers;

import com.cheryomushkin.petclinic.converters.VisitsConverter;
import com.cheryomushkin.petclinic.domain.Owner;
import com.cheryomushkin.petclinic.domain.Pet;
import com.cheryomushkin.petclinic.domain.Visit;
import com.cheryomushkin.petclinic.repository.OwnerRepository;
import com.cheryomushkin.petclinic.repository.PetRepository;
import com.cheryomushkin.petclinic.repository.VisitRepository;
import com.cheryomushkin.petclinic.transport.visits.AddVisitDto;
import com.cheryomushkin.petclinic.transport.visits.GetVisitDto;
import com.cheryomushkin.petclinic.transport.visits.UpdateVisitDto;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Transactional
public class VisitsControllerImpl implements VisitsController {
    final VisitRepository visitRepository;
    final VisitsConverter visitsConverter;
    final PetRepository petRepository;
    final OwnerRepository ownerRepository;


    @Override
    public void create(AddVisitDto addVisitDto) {
        Visit visit = visitsConverter.addVisitDtoToVisit(addVisitDto);
        visit = visitRepository.save(visit);
    }

    @Override
    public @Nullable GetVisitDto get(Long id) {
        Optional<Visit> visit = visitRepository.findById(id);
        if (visit.isEmpty()) return null;
        Pet pet = petRepository.findById(visit.get().getPetId()).orElseThrow();
        Owner owner = ownerRepository.findById(pet.getOwnerId()).orElseThrow();
        return visitsConverter.visitToGetVisitDto(visit.get(), pet, owner);
    }

    @Override
    public void update(Long id, UpdateVisitDto updateVisitDto) {
        Visit visit = visitsConverter.updateVisitDtoToVisit(id, updateVisitDto);
        visitRepository.save(visit);
    }

    @Override
    public void delete(Long id) {
        visitRepository.deleteById(id);
    }
}
