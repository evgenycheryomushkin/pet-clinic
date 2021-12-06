package com.cheryomushkin.petclinic.domain;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Identifier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    Long id;

    public @Nullable Long getId() { return id;}
    public void setId(@NonNull Long id) { this.id = id; }

    /**
     * Returns non-null id property. If id is null then throws
     * {@link RuntimeException}
     * @return id if it is not null, or else throws {@link RuntimeException}
     */
    @NonNull
    public Long ensureId() {
        if (id == null) {
            throw new RuntimeException("id is null");
        }
        return id;
    }
}
