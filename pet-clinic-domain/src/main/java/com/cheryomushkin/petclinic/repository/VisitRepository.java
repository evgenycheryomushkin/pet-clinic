package com.cheryomushkin.petclinic.repository;

import com.cheryomushkin.petclinic.domain.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
    void deleteAllByPetId(Long petId);
}
