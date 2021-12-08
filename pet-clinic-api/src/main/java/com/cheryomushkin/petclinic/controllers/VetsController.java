package com.cheryomushkin.petclinic.controllers;


import com.cheryomushkin.petclinic.transport.vets.CreateVetDto;
import com.cheryomushkin.petclinic.transport.vets.GetVetDto;
import com.cheryomushkin.petclinic.transport.vets.UpdateVetDto;
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
import java.util.List;

@RequestMapping("/petclinic/api/vets")
@Validated
public interface VetsController {
    @PostMapping("")
    void create(@RequestBody @Valid CreateVetDto createVetDto);
    @GetMapping("")
    List<GetVetDto> list();
    @GetMapping("/{id}")
    @Nullable GetVetDto get(@PathVariable Long id);
    @PutMapping("/{id}")
    void update(@PathVariable Long id, @RequestBody @Valid UpdateVetDto updateVetDto);
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);
}
