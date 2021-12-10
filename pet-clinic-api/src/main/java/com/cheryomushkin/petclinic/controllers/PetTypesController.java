package com.cheryomushkin.petclinic.controllers;

import com.cheryomushkin.petclinic.transport.CreatePetTypeDto;
import com.cheryomushkin.petclinic.transport.PetTypeDto;
import com.cheryomushkin.petclinic.transport.UpdatePetTypeDto;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/petclinic/api/pettypes")
@Validated
public interface PetTypesController {
    @GetMapping("")
    Iterable<PetTypeDto> list();
    @GetMapping("/{id}")
    @Nullable PetTypeDto get(@PathVariable Long id);
    @PostMapping("")
    Long create(@RequestBody CreatePetTypeDto createPetTypeDto);
    @PutMapping("/{id}")
    void update(@PathVariable Long id, @RequestBody @Valid UpdatePetTypeDto updatePetTypeDto);
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);
}
