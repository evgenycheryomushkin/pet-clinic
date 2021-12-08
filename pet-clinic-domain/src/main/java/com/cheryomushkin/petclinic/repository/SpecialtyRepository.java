package com.cheryomushkin.petclinic.repository;

import com.cheryomushkin.petclinic.domain.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
