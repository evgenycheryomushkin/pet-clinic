package com.cheryomushkin.petclinic.controllers;

import com.cheryomushkin.petclinic.converters.OwnersConverter;
import com.cheryomushkin.petclinic.domain.Owner;
import com.cheryomushkin.petclinic.repository.OwnerRepository;
import com.cheryomushkin.petclinic.transport.owners.AddOwnerDto;
import com.cheryomushkin.petclinic.transport.owners.GetOwnerDto;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Transactional
public class OwnersControllerImpl implements OwnersController {
    private final OwnersConverter ownersConverter;
    private final OwnerRepository ownerRepository;

    @Override
    public Iterable<GetOwnerDto> list() {
        List<Owner> owners = ownerRepository.findAllByDeletedFalse();
        return ownersConverter.ownersToGetOwnerDtos(owners);
    }

    @Override
    public @Nullable GetOwnerDto getById(Long id) {
        Optional<Owner> owner = ownerRepository.findById(id);
        if (owner.isEmpty()) return null;
        return ownersConverter.ownerToGetOwnerDto(owner.get());
    }

    @Override
    public GetOwnerDto add(AddOwnerDto ownerDto) {
        Owner owner = ownersConverter.addOwnerDtoToOwner(ownerDto);
        owner = ownerRepository.save(owner);
        return ownersConverter.ownerToGetOwnerDto(owner);
    }

    @Override
    public void update(Long id, AddOwnerDto addOwnerDto) {
        Owner owner = ownersConverter.addOwnerDtoIdToOwner(id, addOwnerDto);
        ownerRepository.save(owner);
    }

    @Override
    public void delete(Long id) {
        Owner owner = ownerRepository.findById(id).orElseThrow(); //todo error 400
        owner.setDeleted(true);
        ownerRepository.save(owner);
    }

    @Override
    public Iterable<GetOwnerDto> findByLastnameStart(String start) {
        List<Owner> owners = ownerRepository.findAllByLastNameStartsWith(start);
        return ownersConverter.ownersToGetOwnerDtos(owners);
    }
}
