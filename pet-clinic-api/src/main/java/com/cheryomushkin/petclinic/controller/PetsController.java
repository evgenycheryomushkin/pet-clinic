package com.cheryomushkin.petclinic.controller;

import com.cheryomushkin.petclinic.transport.pets.AddPetDto;
import com.cheryomushkin.petclinic.transport.pets.GetPetDto;
import com.cheryomushkin.petclinic.transport.pets.UpdatePetDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/petclinic/api/pets")
@Validated
public interface PetsController {
    @GetMapping("/{id}")
    GetPetDto getById(@PathVariable Long id);
    @PutMapping("/{id}")
    void update(@PathVariable Long id, @RequestBody @Valid UpdatePetDto updatePetDto);
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);
    @PostMapping("")
    void add(@RequestBody @Valid AddPetDto addPetDto);
}
