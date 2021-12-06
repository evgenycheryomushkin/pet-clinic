package com.cheryomushkin.petclinic.transport.owners;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Value;

import java.time.LocalDate;

import static com.cheryomushkin.petclinic.transport.Constants.DATE_FORMAT;

@Value
public class VisitDto {
    Long id;
    @JsonFormat(pattern = DATE_FORMAT)
    LocalDate date;
    String description;
}
