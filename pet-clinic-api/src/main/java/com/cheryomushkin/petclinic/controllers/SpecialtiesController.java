package com.cheryomushkin.petclinic.controllers;

import com.cheryomushkin.petclinic.transport.SpecialtyDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/petclinic/api/specialties")
@Validated
public interface SpecialtiesController {
    @GetMapping("")
    List<SpecialtyDto> list();
}
