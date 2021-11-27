package com.cheryomushkin.petclinic.transport.visits;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotNull;

@Builder
@Value
@Jacksonized
public class VisitPetDto {
    @NotNull
    Long id;
}
