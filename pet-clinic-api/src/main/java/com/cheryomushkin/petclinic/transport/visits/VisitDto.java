package com.cheryomushkin.petclinic.transport.visits;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

import static com.cheryomushkin.petclinic.transport.Constants.DATE_FORMAT;

@Builder
@Value
@Jacksonized
public class VisitDto {
    Long id;
    @JsonFormat(pattern = DATE_FORMAT)
    LocalDate date;
    String description;
}
