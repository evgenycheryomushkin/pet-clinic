package com.cheryomushkin.petclinic.converters;

import com.cheryomushkin.petclinic.domain.Owner;
import com.cheryomushkin.petclinic.domain.Pet;
import com.cheryomushkin.petclinic.transport.pets.AddPetDto;
import com.cheryomushkin.petclinic.transport.pets.GetPetDto;
import com.cheryomushkin.petclinic.transport.pets.GetPetOwnerDto;
import com.cheryomushkin.petclinic.transport.pets.UpdatePetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PetsConverterImpl implements PetsConverter {
    final Converter converter;

    @Override
    public GetPetOwnerDto ownerToGetPetOwnerDto(Owner owner) {
        return new GetPetOwnerDto(owner.ensureId(), owner.getFirstName(),
                owner.getLastName());
    }

    @Override
    public GetPetDto petAndOwnerToGetPetDto(Pet pet, Owner owner) {
        GetPetOwnerDto ownerDto = ownerToGetPetOwnerDto(owner);
        return new GetPetDto(pet.ensureId(), pet.getName(),
                converter.petTypeToPetTypeDto(pet.getType()),
                pet.getBirthDate(), ownerDto);
    }

    @Override
    public Pet updatePetDtoAndIdToPet(UpdatePetDto updatePetDto, Long id) {
        Pet pet = new Pet(updatePetDto.getName(),
                converter.petTypeDtoToPetType(updatePetDto.getType()),
        updatePetDto.getOwner().getId(), updatePetDto.getBirthDate());
        pet.setId(id);
        return pet;
    }

    @Override
    public Pet addPetDtoAndOwnerIdToPet(AddPetDto addPetDto, Long ownerId) {
        return new Pet(addPetDto.getPetName(),
                converter.petTypeDtoToPetType(addPetDto.getType()), ownerId,
                addPetDto.getBirthDate());
    }
}
