package com.cheryomushkin.petclinic.converters;

import com.cheryomushkin.petclinic.domain.Vet;
import com.cheryomushkin.petclinic.transport.vets.CreateVetDto;
import com.cheryomushkin.petclinic.transport.vets.GetVetDto;
import com.cheryomushkin.petclinic.transport.vets.UpdateVetDto;

import java.util.List;

public interface VetsConverter {
    List<GetVetDto> vetsToGetVetDtos(Iterable<Vet> vets);
    GetVetDto vetToGetVetDto(Vet vet);
    Vet updateVetDtoAndIdToVet(Long id, UpdateVetDto updateVetDto);
    Vet createVetDtoToVet(CreateVetDto createVetDto);
}
