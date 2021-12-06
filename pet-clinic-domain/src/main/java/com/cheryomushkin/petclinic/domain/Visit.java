package com.cheryomushkin.petclinic.domain;

import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Visit extends Identifier {

    @SuppressWarnings("initialization.fields.uninitialized")
    protected Visit() {}

    public Visit(LocalDate date, String description, Long petId) {
        this.date = date;
        this.description = description;
        this.petId = petId;
    }

    @NotNull
    LocalDate date;

    @Lob @NotNull @NotEmpty
    String description;

    @NotNull
    Long petId;

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Visit visit = (Visit) o;
        return Objects.equals(id, visit.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
