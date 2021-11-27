package com.cheryomushkin.petclinic.controllers;

import com.cheryomushkin.petclinic.transport.pets.PetTypeDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/petclinic/api/pettypes")
@Validated
public interface PetTypesController {
    @GetMapping("")
    Iterable<PetTypeDto> list();
}
