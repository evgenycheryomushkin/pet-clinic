package com.cheryomushkin.petclinic.converters;

import com.cheryomushkin.petclinic.domain.PetType;
import com.cheryomushkin.petclinic.transport.PetTypeDto;

public interface Converter {
    PetTypeDto petTypeToPetTypeDto(PetType petType);
    Iterable<PetTypeDto> petTypesToPetTypeDtos(Iterable<PetType> petTypes);
    PetType petTypeDtoToPetType(PetTypeDto type);
}
