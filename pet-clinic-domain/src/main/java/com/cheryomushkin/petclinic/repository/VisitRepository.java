package com.cheryomushkin.petclinic.repository;

import com.cheryomushkin.petclinic.domain.Visit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VisitRepository extends CrudRepository<Visit, Long> {
    void deleteAllByPetId(Long petId);
    List<Visit> findAllByPetId(Long petId);
}
