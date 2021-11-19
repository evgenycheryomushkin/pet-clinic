package com.cheryomushkin.petclinic.transport;

import lombok.Builder;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data @Builder
public class PetDto {
    @NotNull @NotEmpty @NonNull
    String name;
}
