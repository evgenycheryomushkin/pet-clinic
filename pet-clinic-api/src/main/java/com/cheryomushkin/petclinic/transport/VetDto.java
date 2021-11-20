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
public class VetDto {
    @NotNull @NonNull Long id;
    @NonNull @NotNull @NotEmpty String firstName;
    @NotNull @NonNull @NotEmpty String lastName;
}
