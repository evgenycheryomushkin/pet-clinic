package com.cheryomushkin.petclinic.controllers;

import com.cheryomushkin.petclinic.converters.Converter;
import com.cheryomushkin.petclinic.domain.PetType;
import com.cheryomushkin.petclinic.repository.PetTypeRepository;
import com.cheryomushkin.petclinic.transport.common.CreatePetTypeDto;
import com.cheryomushkin.petclinic.transport.common.PetTypeDto;
import com.cheryomushkin.petclinic.transport.common.UpdatePetTypeDto;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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
    @Override
    public @Nullable PetTypeDto get(Long id) {
        Optional<PetType> petType = petTypeRepository.findById(id);
        if (petType.isEmpty()) return null;
        return converter.petTypeToPetTypeDto(petType.get());
    }
    @Override
    public PetTypeDto create(CreatePetTypeDto createPetTypeDto) {
        PetType petType = converter.createPetTypeDtoToPetType(createPetTypeDto);
        petType = petTypeRepository.save(petType);
        return converter.petTypeToPetTypeDto(petType);
    }

    @Override
    public void update(Long id, UpdatePetTypeDto updatePetTypeDto) {
        PetType petType = converter.updatePetTypeDtoToPetType(id, updatePetTypeDto);
        petTypeRepository.save(petType);
    }
    @Override
    public void delete(Long id) {
        petTypeRepository.deleteById(id);
    }
}
