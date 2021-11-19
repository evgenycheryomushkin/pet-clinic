package com.cheryomushkin.petclinic.controller;

import com.cheryomushkin.petclinic.transport.OwnerDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/petclinic/api/owners")
public interface OwnerController {
    @GetMapping("")
    Iterable<OwnerDto> owners();
}
