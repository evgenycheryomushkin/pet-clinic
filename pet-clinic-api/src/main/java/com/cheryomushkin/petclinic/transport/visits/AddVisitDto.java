package com.cheryomushkin.petclinic.transport.visits;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

import static com.cheryomushkin.petclinic.transport.Constants.DATE_FORMAT;

@Builder
@Value
@Jacksonized
public class AddVisitDto {
    @NotNull
    @JsonFormat(pattern = DATE_FORMAT)
    LocalDate date;
    @NotNull @NotEmpty
    String description;
    @NotNull
    VisitPetDto pet;
}
