package com.cheryomushkin.petclinic.transport.visits;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Value;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

import static com.cheryomushkin.petclinic.transport.Constants.DATE_FORMAT;

@Value
public class AddVisitDto {
    @JsonFormat(pattern = DATE_FORMAT)
    @NotNull
    LocalDate date;
    @NotNull @NotEmpty
    String description;
    @NotNull
    PetIdDto pet;
}
