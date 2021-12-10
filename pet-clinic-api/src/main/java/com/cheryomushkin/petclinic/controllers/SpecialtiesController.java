package com.cheryomushkin.petclinic.controllers;

import com.cheryomushkin.petclinic.transport.CreateSpecialtyDto;
import com.cheryomushkin.petclinic.transport.SpecialtyDto;
import com.cheryomushkin.petclinic.transport.UpdateSpecialtyDto;
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

@RequestMapping("/petclinic/api/specialties")
@Validated
public interface SpecialtiesController {
    @GetMapping("")
    List<SpecialtyDto> list();
    @GetMapping("/{id}")
    @Nullable SpecialtyDto get(@PathVariable Long id);
    @PostMapping("")
    Long create(@RequestBody @Valid CreateSpecialtyDto createSpecialtyDto);
    @PutMapping("/{id}")
    void put(@PathVariable Long id, @RequestBody @Valid UpdateSpecialtyDto updateSpecialtyDto);
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);
}
