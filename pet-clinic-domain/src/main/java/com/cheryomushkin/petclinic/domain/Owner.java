package com.cheryomushkin.petclinic.domain;

import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Owner extends Identifier {
    @NotNull @NotEmpty
    String firstName;
    @NotNull @NotEmpty
    String lastName;
    @NotNull @NotEmpty
    String address;
    @NotNull @NotEmpty
    String city;
    @NotNull @NotEmpty
    String telephone;

    @OneToMany(mappedBy = "ownerId")
    @NotNull
    List<Pet> pets = new ArrayList<>();

    @SuppressWarnings("initialization.fields.uninitialized")
    protected Owner() {}

    public Owner(String firstName, String lastName, String address, String city, String telephone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Owner owner = (Owner) o;
        return Objects.equals(id, owner.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }

}
