package com.cheryomushkin.petclinic.controller;

import com.cheryomushkin.petclinic.transport.OwnerDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/petclinic/api/owners")
@Validated
public interface OwnerController {
    @GetMapping("")
    Iterable<OwnerDto> owners();
    @GetMapping("/{ownerId}")
    OwnerDto getOwnerById(@PathVariable Long ownerId);
    @PostMapping("")
    Long addOwner(@RequestBody @Valid  OwnerDto ownerDto);
}
