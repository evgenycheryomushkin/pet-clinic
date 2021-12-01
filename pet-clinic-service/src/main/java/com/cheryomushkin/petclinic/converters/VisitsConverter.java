package com.cheryomushkin.petclinic.converters;

import com.cheryomushkin.petclinic.domain.Visit;
import com.cheryomushkin.petclinic.transport.visits.AddVisitDto;

public interface VisitsConverter {
    Visit addVisitDtoToVisit(AddVisitDto addVisitDto);
}
