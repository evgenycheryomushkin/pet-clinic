package com.cheryomushkin.petclinic.controllers;

import com.cheryomushkin.petclinic.converters.OwnersConverter;
import com.cheryomushkin.petclinic.domain.Owner;
import com.cheryomushkin.petclinic.repository.OwnerRepository;
import com.cheryomushkin.petclinic.transport.owners.AddOwnerDto;
import com.cheryomushkin.petclinic.transport.owners.GetOwnerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class OwnersControllerImpl implements OwnersController {
    private final OwnersConverter ownersConverter;
    private final OwnerRepository ownerRepository;

    @Override
    public Iterable<GetOwnerDto> list() {
        Iterable<Owner> owners = ownerRepository.findAll();
        return ownersConverter.mapOwnersGet(owners);
    }

    @Override
    public GetOwnerDto getById(Long id) {
        Optional<Owner> owner = ownerRepository.findById(id);
        if (owner.isEmpty()) return null;
        return ownersConverter.mapOwnerGet(owner.get());
    }

    @Override
    public Long add(AddOwnerDto ownerDto) {
        Owner owner = ownersConverter.mapAddOwnerDto(ownerDto);
        return ownerRepository.save(owner).getId();
    }

    @Override
    public void update(Long id, AddOwnerDto addOwnerDto) {
        Owner owner = ownersConverter.mapAddOwnerDto(addOwnerDto);
        owner.setId(id);
        ownerRepository.save(owner);
    }

    @Override
    public void delete(Long id) {
        ownerRepository.deleteById(id);
    }
}
