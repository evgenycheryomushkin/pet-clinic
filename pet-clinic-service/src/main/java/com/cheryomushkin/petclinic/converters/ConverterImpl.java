package com.cheryomushkin.petclinic.converters;

import com.cheryomushkin.petclinic.domain.PetType;
import com.cheryomushkin.petclinic.domain.Specialty;
import com.cheryomushkin.petclinic.transport.common.CreatePetTypeDto;
import com.cheryomushkin.petclinic.transport.common.CreateSpecialtyDto;
import com.cheryomushkin.petclinic.transport.common.PetTypeDto;
import com.cheryomushkin.petclinic.transport.common.SpecialtyDto;
import com.cheryomushkin.petclinic.transport.common.UpdatePetTypeDto;
import com.cheryomushkin.petclinic.transport.common.UpdateSpecialtyDto;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public PetType petTypeDtoToPetType(PetTypeDto typeDto) {
        PetType petType = new PetType(typeDto.getName());
        petType.setId(typeDto.getId());
        return petType;
    }
    @Override
    public List<SpecialtyDto> specialitiesToSpecialityDtos(Iterable<Specialty> specialities) {
        return StreamSupport.stream(specialities.spliterator(), false)
                .map(this::specialityToSpecialityDto).collect(Collectors.toList());
    }
    @Override
    public SpecialtyDto specialityToSpecialityDto(Specialty specialty) {
        return new SpecialtyDto(specialty.ensureId(), specialty.getName());
    }
    @Override
    public List<Specialty> updateSpecialtyDtosToSpecialties(Iterable<UpdateSpecialtyDto> specialtyDtos) {
        return StreamSupport.stream(specialtyDtos.spliterator(), false)
                .map(this::updateSpecialtyDtoToSpecialty).collect(Collectors.toList());
    }
    @Override
    public Specialty updateSpecialtyDtoToSpecialty(UpdateSpecialtyDto specialtyDto) {
        Specialty specialty = new Specialty(specialtyDto.getName());
        specialty.setId(specialtyDto.getId());
        return specialty;
    }
    @Override
    public PetType updatePetTypeDtoToPetType(Long id, UpdatePetTypeDto updatePetTypeDto) {
        PetType petType = new PetType(updatePetTypeDto.getName());
        petType.setId(id);
        return petType;
    }
    @Override
    public PetType createPetTypeDtoToPetType(CreatePetTypeDto createPetTypeDto) {
        return new PetType(createPetTypeDto.getName());
    }
    @Override
    public Specialty updateSpecialtyDtoToSpecialty(Long id, UpdateSpecialtyDto updateSpecialtyDto) {
        Specialty specialty = new Specialty(updateSpecialtyDto.getName());
        specialty.setId(id);
        return specialty;
    }
    @Override
    public Specialty createSpecialtyDtoToSpecialty(CreateSpecialtyDto createSpecialtyDto) {
        return new Specialty(createSpecialtyDto.getName());
    }
}
