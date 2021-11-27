package com.cheryomushkin.petclinic.converters;

import com.cheryomushkin.petclinic.domain.Visit;
import com.cheryomushkin.petclinic.transport.visits.AddVisitDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface VisitsConverter {
    @Mapping(target = "petId", source = "pet.id")
    @Mapping(target = "id", ignore = true)
    Visit mapAddVisitDto(AddVisitDto addVisitDto);
}
