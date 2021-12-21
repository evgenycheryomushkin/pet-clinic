package com.cheryomushkin.petclinic.domain;

import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Vet extends Identifier {
    @NotNull @NotEmpty String firstName;
    @NotNull @NotEmpty String lastName;
    @ManyToMany(fetch = FetchType.EAGER)
    @NotNull List<Specialty> specialties;

    @SuppressWarnings("initialization.fields.uninitialized")
    protected Vet() {}

    public Vet(String firstName, String lastName, List<Specialty> specialties) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialties = specialties;
    }

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Vet vet = (Vet) o;
        return Objects.equals(id, vet.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
