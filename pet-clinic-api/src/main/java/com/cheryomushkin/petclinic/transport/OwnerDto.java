package com.cheryomushkin.petclinic.transport;

import lombok.Data;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class OwnerDto {
    @NotNull @NonNull
    Long id;
    @NotNull @NotEmpty @NonNull
    String firstName;
    @NotNull @NotEmpty @NonNull
    String lastName;
}
