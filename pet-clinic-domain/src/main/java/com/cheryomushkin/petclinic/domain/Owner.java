package com.cheryomushkin.petclinic.domain;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Owner {
    @Nullable
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NonNull @NotNull @NotEmpty
    String firstName;
    @NonNull @NotNull @NotEmpty
    String lastName;
    @NonNull @NotNull @NotEmpty
    String address;
    @NonNull @NotNull @NotEmpty
    String city;
    @NonNull @NotNull @NotEmpty
    String telephone;

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
