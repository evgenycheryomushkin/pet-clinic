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

import javax.validation.constraints.NotNull;
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
        return petConverter.mapPet(pet.get());
    }

    @Override
    public void put(Long id, UpdatePetDto addPetDto) {
        // todo find better way
        @NotNull Owner owner = petRepository.findById(id).get().getOwner();
        Pet pet = petConverter.mapUpdatePetDto(addPetDto, owner);
        pet.setId(id);
        petRepository.save(pet);
    }

    @Override
    public void delete(Long id) {
        petRepository.deleteById(id);
    }

    @Override
    public void add(AddPetDto addPetDto) {
        Optional<Owner> owner = ownerRepository.findById(addPetDto.getOwner().getId());
        Pet pet = petConverter.mapAddPetDto(addPetDto, owner.get());
        petRepository.save(pet);
    }
}
