package com.cheryomushkin.petclinic.transport;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.OffsetDateTime;

@Builder
@Value
@Jacksonized
public class GetOwnerPetDto {
    Long id;
    String name;
    GetPetTypeDto petType;
    OffsetDateTime birthday;
}
