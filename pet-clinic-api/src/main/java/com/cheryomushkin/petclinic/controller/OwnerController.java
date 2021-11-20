package com.cheryomushkin.petclinic.controller;

import com.cheryomushkin.petclinic.transport.AddOwnerDto;
import com.cheryomushkin.petclinic.transport.GetOwnerDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/petclinic/api/owners")
@Validated
public interface OwnerController {
    @GetMapping("")
    Iterable<GetOwnerDto> owners();
    @GetMapping("/{ownerId}")
    GetOwnerDto getOwnerById(@PathVariable Long ownerId);
    @PostMapping("")
    Long addOwner(@RequestBody @Valid AddOwnerDto ownerDto);
}
