package com.cheryomushkin.petclinic.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Owner {
    @Nullable
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NonNull
    @NotNull @NotEmpty String firstName;
    @NonNull
    @NotNull @NotEmpty String lastName;
    @NotNull @NonNull
    @OneToMany(mappedBy = "owner")
    List<Pet> pets = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
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
