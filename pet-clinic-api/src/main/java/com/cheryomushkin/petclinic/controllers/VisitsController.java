package com.cheryomushkin.petclinic.controllers;

import com.cheryomushkin.petclinic.transport.visits.AddVisitDto;
import com.cheryomushkin.petclinic.transport.visits.GetVisitDto;
import com.cheryomushkin.petclinic.transport.visits.UpdateVisitDto;
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

@RequestMapping("/petclinic/api/visits")
@Validated
public interface VisitsController {
    @PostMapping("")
    GetVisitDto create(@RequestBody @Valid AddVisitDto addVisitDto);
    @GetMapping("/{id}")
    @Nullable GetVisitDto get(@PathVariable Long id);
    @PutMapping("/{id}")
    void update(@PathVariable Long id, @RequestBody @Valid UpdateVisitDto updateVisitDto);
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);
}
