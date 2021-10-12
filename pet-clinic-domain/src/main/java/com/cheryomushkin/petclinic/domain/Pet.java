package com.cheryomushkin.petclinic.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.time.LocalDate;

@Data
@Builder
public class Pet {
    @Nullable String name;
    @NonNull PetType petType;
    @NonNull Owner owner;
    @NonNull LocalDate birthday;
}
