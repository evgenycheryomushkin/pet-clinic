package com.cheryomushkin.petclinic.domain;

import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Specialty extends Identifier {
    @NotNull @NotEmpty String name;

    public Specialty(String name) {
        this.name = name;
    }

    @SuppressWarnings("initialization.fields.uninitialized")
    protected Specialty() {}

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Specialty vet = (Specialty) o;
        return Objects.equals(id, vet.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
