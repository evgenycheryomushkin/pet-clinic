package com.cheryomushkin.petclinic.domain;

import lombok.Builder;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDate;

@Data
@Builder
public class Pet {
    @Nullable String name;
    @NotNull PetType petType;
    @NotNull Owner owner;
    @NotNull LocalDate birthday;
}
