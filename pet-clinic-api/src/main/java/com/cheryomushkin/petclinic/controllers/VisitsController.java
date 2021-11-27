package com.cheryomushkin.petclinic.controllers;

import com.cheryomushkin.petclinic.transport.visits.AddVisitDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/petclinic/api/visits")
@Validated
public interface VisitsController {
    @PostMapping("")
    void create(@RequestBody @Valid AddVisitDto addVisitDto);
}
