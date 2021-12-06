package com.cheryomushkin.petclinic.transport.visits;

import lombok.Value;

import java.time.LocalDate;

@Value
public class GetVisitDto {
    Long id;
    String description;
    LocalDate date;
    GetVisitPetDto pet;
}
