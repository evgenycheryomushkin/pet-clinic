package com.cheryomushkin.petclinic.converters;

import com.cheryomushkin.petclinic.domain.PetType;
import com.cheryomushkin.petclinic.transport.PetTypeDto;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ConverterImpl implements Converter {
    @Override
    public PetTypeDto petTypeToPetTypeDto(PetType petType) {
        return new PetTypeDto(petType.ensureId(), petType.getName());
    }

    @Override
    public Iterable<PetTypeDto> petTypesToPetTypeDtos(Iterable<PetType> petTypes) {
        return StreamSupport.stream(petTypes.spliterator(), false)
                .map(this::petTypeToPetTypeDto)
                .collect(Collectors.toList());
    }

    @Override
    public PetType petTypeDtoToPetType(PetTypeDto type) {
        PetType petType = new PetType(type.getName());
        petType.setId(type.getId());
        return petType;
    }
}
