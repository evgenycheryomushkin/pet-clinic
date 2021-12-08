package com.cheryomushkin.petclinic.controllers;

import com.cheryomushkin.petclinic.converters.Converter;
import com.cheryomushkin.petclinic.domain.Specialty;
import com.cheryomushkin.petclinic.repository.SpecialtyRepository;
import com.cheryomushkin.petclinic.transport.SpecialtyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
