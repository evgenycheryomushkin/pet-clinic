package com.cheryomushkin.petclinic.converters;

import com.cheryomushkin.petclinic.domain.Visit;
import com.cheryomushkin.petclinic.transport.visits.AddVisitDto;
import org.springframework.stereotype.Service;

@Service
public class VisitsConverterImpl implements VisitsConverter {
    @Override
    public Visit addVisitDtoToVisit(AddVisitDto addVisitDto) {
        return new Visit(addVisitDto.getDate(), addVisitDto.getDescription(), addVisitDto.getPet().getId());
    }
}
