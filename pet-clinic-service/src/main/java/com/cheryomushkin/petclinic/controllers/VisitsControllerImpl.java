package com.cheryomushkin.petclinic.controllers;

import com.cheryomushkin.petclinic.converters.VisitsConverter;
import com.cheryomushkin.petclinic.domain.Visit;
import com.cheryomushkin.petclinic.repository.VisitRepository;
import com.cheryomushkin.petclinic.transport.visits.AddVisitDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VisitsControllerImpl implements VisitsController {
    private final VisitRepository visitRepository;
    private final VisitsConverter visitsConverter;


    @Override
    public void create(AddVisitDto addVisitDto) {
        Visit visit = visitsConverter.addVisitDtoToVisit(addVisitDto);
        visitRepository.save(visit);
    }
}
