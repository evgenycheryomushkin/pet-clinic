package com.cheryomushkin.petclinic.transport;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@Value
@Jacksonized
public class OwnerDto {
    @Nullable
    Long id;
    @NotNull @NotEmpty @NonNull
    String firstName;
    @NotNull @NotEmpty @NonNull
    String lastName;
    @NotNull @NotEmpty @NonNull
    String address;
    @NotNull @NotEmpty @NonNull
    String city;
    @NotNull @NotEmpty @NonNull
    String telephone;
    @NotNull @NonNull
    List<PetDto> pets;
}
