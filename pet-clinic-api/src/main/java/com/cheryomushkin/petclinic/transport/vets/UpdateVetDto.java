package com.cheryomushkin.petclinic.transport.vets;

import com.cheryomushkin.petclinic.transport.UpdateSpecialtyDto;
import lombok.Value;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Value
public class UpdateVetDto {
    @NotNull @NotEmpty String firstName;
    @NotNull @NotEmpty String lastName;
    @NotNull List<UpdateSpecialtyDto> specialties;
}
