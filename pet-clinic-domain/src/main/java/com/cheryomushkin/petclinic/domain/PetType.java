package com.cheryomushkin.petclinic.domain;

import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Getter
@Setter
public class PetType extends Identifier {

    @SuppressWarnings("initialization.fields.uninitialized")
    protected PetType() {}

    public PetType(String name) {
        this.name = name;
    }

    @NotNull String name;

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PetType petType = (PetType) o;
        return Objects.equals(id, petType.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
