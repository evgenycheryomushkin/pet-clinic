package com.cheryomushkin.petclinic.controllers;

import com.cheryomushkin.petclinic.converters.PetsConverter;
import com.cheryomushkin.petclinic.domain.PetType;
import com.cheryomushkin.petclinic.repository.PetTypeRepository;
import com.cheryomushkin.petclinic.transport.pets.PetTypeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PetTypesControllerImpl implements PetTypesController {
    final PetTypeRepository petTypeRepository;
    final PetsConverter petsConverter;

    @Override
    public Iterable<PetTypeDto> list() {
        Iterable<PetType> petTypes = petTypeRepository.findAll();
        return petsConverter.mapPetTypes(petTypes);
    }
}
