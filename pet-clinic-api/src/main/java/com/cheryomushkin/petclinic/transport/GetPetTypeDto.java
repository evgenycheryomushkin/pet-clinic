package com.cheryomushkin.petclinic.transport;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class GetPetTypeDto {
    Long id;
    String name;
}
