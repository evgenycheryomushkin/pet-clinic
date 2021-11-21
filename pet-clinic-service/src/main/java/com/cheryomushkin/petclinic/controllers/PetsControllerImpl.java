package com.cheryomushkin.petclinic.controllers;

import com.cheryomushkin.petclinic.controller.PetsController;
import com.cheryomushkin.petclinic.converters.PetConverter;
import com.cheryomushkin.petclinic.domain.Owner;
import com.cheryomushkin.petclinic.domain.Pet;
import com.cheryomushkin.petclinic.repository.PetRepository;
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
        Pet pet = petConverter.mapAddPetDto(addPetDto, owner);
        pet.setId(id);
        petRepository.save(pet);
    }
}
