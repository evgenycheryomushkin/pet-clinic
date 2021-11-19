package com.cheryomushkin.petclinic.controllers;

import com.cheryomushkin.petclinic.controller.OwnerController;
import com.cheryomushkin.petclinic.converters.Converter;
import com.cheryomushkin.petclinic.domain.Owner;
import com.cheryomushkin.petclinic.repository.OwnerRepository;
import com.cheryomushkin.petclinic.transport.OwnerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OwnerControllerImpl implements OwnerController {
    private final Converter converter;
    private final OwnerRepository ownerRepository;

    @Override
    public Iterable<OwnerDto> owners() {
        Iterable<Owner> owners = ownerRepository.findAll();
        return converter.mapOwners(owners);
    }
}
