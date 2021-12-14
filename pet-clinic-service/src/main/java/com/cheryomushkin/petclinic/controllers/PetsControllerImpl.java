package com.cheryomushkin.petclinic.controllers;

import com.cheryomushkin.petclinic.converters.PetsConverter;
import com.cheryomushkin.petclinic.domain.Owner;
import com.cheryomushkin.petclinic.domain.Pet;
import com.cheryomushkin.petclinic.repository.OwnerRepository;
import com.cheryomushkin.petclinic.repository.PetRepository;
import com.cheryomushkin.petclinic.repository.VisitRepository;
import com.cheryomushkin.petclinic.transport.pets.AddPetDto;
import com.cheryomushkin.petclinic.transport.pets.GetPetDto;
import com.cheryomushkin.petclinic.transport.pets.UpdatePetDto;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Transactional
public class PetsControllerImpl implements PetsController {
    final PetRepository petRepository;
    final PetsConverter petsConverter;
    final OwnerRepository ownerRepository;
    final VisitRepository visitRepository;

    @Override
    public @Nullable GetPetDto getById(Long id) {
        Optional<Pet> pet = petRepository.findById(id);
        if (pet.isEmpty()) return null;
        Owner owner = ownerRepository.findById(pet.get().getOwnerId()).orElseThrow();
        return petsConverter.petAndOwnerToGetPetDto(pet.get(), owner);
    }

    @Override
    public void update(Long id, UpdatePetDto updatePetDto) {
        Pet pet = petsConverter.updatePetDtoAndIdToPet(id, updatePetDto);
        petRepository.save(pet);
    }

    @Override
    public void delete(Long id) {
        visitRepository.deleteAllByPetId(id);
        petRepository.deleteById(id);

    }

    @Override
    public GetPetDto add(AddPetDto addPetDto) {
        Pet pet = petsConverter.addPetDtoAndOwnerIdToPet(addPetDto, addPetDto.getOwner().getId());
        pet = petRepository.save(pet);
        return petsConverter.petAndOwnerToGetPetDto(pet, ownerRepository.findById(pet.getOwnerId()).orElseThrow());
    }
}
