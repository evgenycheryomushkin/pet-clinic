package com.cheryomushkin.petclinic.controllers;

import com.cheryomushkin.petclinic.converters.Converter;
import com.cheryomushkin.petclinic.domain.Specialty;
import com.cheryomushkin.petclinic.repository.SpecialtyRepository;
import com.cheryomushkin.petclinic.transport.common.CreateSpecialtyDto;
import com.cheryomushkin.petclinic.transport.common.SpecialtyDto;
import com.cheryomushkin.petclinic.transport.common.UpdateSpecialtyDto;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Transactional
public class SpecialtiesControllerImpl implements SpecialtiesController {

    final SpecialtyRepository specialtyRepository;
    final Converter converter;

    @Override
    public List<SpecialtyDto> list() {
        Iterable<Specialty> specialties = specialtyRepository.findAll();
        return converter.specialitiesToSpecialityDtos(specialties);
    }
    @Override
    public @Nullable SpecialtyDto get(Long id) {
        Optional<Specialty> specialty = specialtyRepository.findById(id);
        if (specialty.isEmpty()) return null;
        return converter.specialityToSpecialityDto(specialty.get());
    }
    @Override
    public SpecialtyDto create(CreateSpecialtyDto createSpecialtyDto) {
        Specialty specialty = converter.createSpecialtyDtoToSpecialty(createSpecialtyDto);
        specialty = specialtyRepository.save(specialty);
        return converter.specialityToSpecialityDto(specialty);
    }
    @Override
    public void put(Long id, UpdateSpecialtyDto updateSpecialtyDto) {
        Specialty specialty = converter.updateSpecialtyDtoToSpecialty(id, updateSpecialtyDto);
        specialtyRepository.save(specialty);
    }

    @Override
    public void delete(Long id) {
        specialtyRepository.deleteById(id);
    }
}
