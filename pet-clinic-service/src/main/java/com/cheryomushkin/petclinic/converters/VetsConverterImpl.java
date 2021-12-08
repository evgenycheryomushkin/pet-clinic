package com.cheryomushkin.petclinic.converters;

import com.cheryomushkin.petclinic.domain.Vet;
import com.cheryomushkin.petclinic.transport.vets.CreateVetDto;
import com.cheryomushkin.petclinic.transport.vets.GetVetDto;
import com.cheryomushkin.petclinic.transport.vets.UpdateVetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class VetsConverterImpl implements VetsConverter {
    final Converter converter;

    @Override
    public GetVetDto vetToGetVetDto(Vet vet) {
        return new GetVetDto(vet.ensureId(), vet.getFirstName(), vet.getLastName(),
                converter.specialitiesToSpecialityDtos(vet.getSpecialties()));
    }
    @Override
    public Vet updateVetDtoAndIdToVet(Long id, UpdateVetDto updateVetDto) {
        Vet vet = new Vet(updateVetDto.getFirstName(), updateVetDto.getLastName(),
                converter.updateSpecialtyDtosToSpecialties(updateVetDto.getSpecialties()));
        vet.setId(id);
        return vet;
    }
    @Override
    public Vet createVetDtoToVet(CreateVetDto createVetDto) {
        return new Vet(createVetDto.getFirstName(), createVetDto.getLastName(), converter.updateSpecialtyDtosToSpecialties(createVetDto.getSpecialties()));
    }
    @Override
    public List<GetVetDto> vetsToGetVetDtos(Iterable<Vet> vets) {
        return StreamSupport.stream(vets.spliterator(), false)
                .map(this::vetToGetVetDto).collect(Collectors.toList());
    }
}
