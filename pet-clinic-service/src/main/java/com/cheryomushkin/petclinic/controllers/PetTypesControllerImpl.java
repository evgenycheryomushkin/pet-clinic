package com.cheryomushkin.petclinic.controllers;

import com.cheryomushkin.petclinic.converters.Converter;
import com.cheryomushkin.petclinic.domain.PetType;
import com.cheryomushkin.petclinic.repository.PetTypeRepository;
import com.cheryomushkin.petclinic.transport.PetTypeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Transactional
public class PetTypesControllerImpl implements PetTypesController {
    final PetTypeRepository petTypeRepository;
    final Converter converter;

    @Override
    public Iterable<PetTypeDto> list() {
        Iterable<PetType> petTypes = petTypeRepository.findAll();
        return converter.petTypesToPetTypeDtos(petTypes);
    }
}
