package com.cheryomushkin.petclinic.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.lang.NonNull;

@Data
@Builder
public class Vet {
    @NonNull String firstName;
    @NonNull String lastName;
}
