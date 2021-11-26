package com.cheryomushkin.petclinic.controllers;

import com.cheryomushkin.petclinic.controller.PetsController;
import com.cheryomushkin.petclinic.converters.PetConverter;
import com.cheryomushkin.petclinic.domain.Owner;
import com.cheryomushkin.petclinic.domain.Pet;
import com.cheryomushkin.petclinic.repository.OwnerRepository;
import com.cheryomushkin.petclinic.repository.PetRepository;
import com.cheryomushkin.petclinic.transport.pets.AddPetDto;
import com.cheryomushkin.petclinic.transport.pets.GetPetDto;
import com.cheryomushkin.petclinic.transport.pets.UpdatePetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PetsControllerImpl implements PetsController {
    final PetRepository petRepository;
    final PetConverter petConverter;
    final OwnerRepository ownerRepository;

    @Override
    public GetPetDto getById(Long id) {
        Optional<Pet> pet = petRepository.findById(id);
        if (pet.isEmpty()) return null;
        Optional<Owner> owner = ownerRepository.findById(pet.get().getOwnerId());
        return petConverter.mapPet(pet.get(), owner.get());
    }

    @Override
    public void update(Long id, UpdatePetDto updatePetDto) {
        Pet pet = petConverter.mapUpdatePetDto(updatePetDto);
        pet.setId(id);
        petRepository.save(pet);
    }

    @Override
    public void delete(Long id) {
        petRepository.deleteById(id);
    }

    @Override
    public void add(AddPetDto addPetDto) {
        Pet pet = petConverter.mapAddPetDto(addPetDto, addPetDto.getOwner().getId());
        petRepository.save(pet);
    }
}
