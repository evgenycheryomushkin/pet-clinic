package com.cheryomushkin.petclinic.domain;

import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Pet extends Identifier{
    @NotNull String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull PetType type;
    @NotNull Long ownerId;
    @NotNull LocalDate birthDate;
    @OneToMany(mappedBy = "petId", fetch = FetchType.LAZY)
    @NotNull List<Visit> visits;

    @SuppressWarnings("initialization.fields.uninitialized")
    protected Pet() {}

    public Pet(String name, PetType type, Long ownerId, LocalDate birthDate, List<Visit> visits) {
        this.name = name;
        this.type = type;
        this.ownerId = ownerId;
        this.birthDate = birthDate;
        this.visits = visits;
    }

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Pet pet = (Pet) o;
        return Objects.equals(id, pet.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
