package com.cheryomushkin.petclinic.transport;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@Value
@Jacksonized
public class PetDto {
    @NotNull @NotEmpty @NonNull
    String name;
}
