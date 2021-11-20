package com.cheryomushkin.petclinic.controllers;

import com.cheryomushkin.petclinic.controller.OwnerController;
import com.cheryomushkin.petclinic.converters.OwnerConverter;
import com.cheryomushkin.petclinic.domain.Owner;
import com.cheryomushkin.petclinic.repository.OwnerRepository;
import com.cheryomushkin.petclinic.transport.AddOwnerDto;
import com.cheryomushkin.petclinic.transport.GetOwnerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class OwnerControllerImpl implements OwnerController {
    private final OwnerConverter ownerConverter;
    private final OwnerRepository ownerRepository;

    @Override
    public Iterable<GetOwnerDto> owners() {
        Iterable<Owner> owners = ownerRepository.findAll();
        return ownerConverter.mapOwnersGet(owners);
    }

    @Override
    public GetOwnerDto getOwnerById(Long ownerId) {
        Optional<Owner> owner = ownerRepository.findById(ownerId);
        if (owner.isEmpty()) return null;
        return ownerConverter.mapOwnerGet(owner.get());
    }

    @Override
    public Long addOwner(AddOwnerDto ownerDto) {
        Owner owner = ownerConverter.mapAddOwnerDto(ownerDto);
        return ownerRepository.save(owner).getId();
    }

}
