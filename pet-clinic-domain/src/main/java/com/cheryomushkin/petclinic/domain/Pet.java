package com.cheryomushkin.petclinic.domain;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Pet {
    @Nullable
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Nullable String name;
    @ManyToOne
    @NonNull @NotNull PetType type;
    @ManyToOne
    @NonNull @NotNull Owner owner;
    @NonNull @NotNull LocalDate birthDate;

    @Override
    public boolean equals(Object o) {
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
