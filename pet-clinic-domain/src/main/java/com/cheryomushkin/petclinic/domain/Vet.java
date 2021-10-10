package com.cheryomushkin.petclinic.domain;

import lombok.Builder;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
@Builder
public class Vet {
    @NotNull String firstName;
    @NotNull String lastName;
}
