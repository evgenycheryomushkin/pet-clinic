package com.cheryomushkin.petclinic.controllers;

import com.cheryomushkin.petclinic.converters.VetsConverter;
import com.cheryomushkin.petclinic.domain.Vet;
import com.cheryomushkin.petclinic.repository.VetRepository;
import com.cheryomushkin.petclinic.transport.vets.CreateVetDto;
import com.cheryomushkin.petclinic.transport.vets.GetVetDto;
import com.cheryomushkin.petclinic.transport.vets.UpdateVetDto;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Transactional
public class VetsControllerImpl implements VetsController {
    final VetRepository vetRepository;
    final VetsConverter vetsConverter;

    @Override
    public GetVetDto create(CreateVetDto createVetDto) {
        Vet vet = vetsConverter.createVetDtoToVet(createVetDto);
        vet = vetRepository.save(vet);
        return vetsConverter.vetToGetVetDto(vet);
    }
    @Override
    public List<GetVetDto> list() {
        Iterable<Vet> vets = vetRepository.findAll();
        return vetsConverter.vetsToGetVetDtos(vets);
    }
    @Override
    public @Nullable GetVetDto get(Long id) {
        Optional<Vet> vet = vetRepository.findById(id);
        if (vet.isEmpty()) return null;
        return vetsConverter.vetToGetVetDto(vet.get());
    }
    @Override
    public void update(Long id, UpdateVetDto updateVetDto) {
        Vet vet = vetsConverter.updateVetDtoAndIdToVet(id, updateVetDto);
        vetRepository.save(vet);
    }
    @Override
    public void delete(Long id) {
        vetRepository.deleteById(id);
    }
}
