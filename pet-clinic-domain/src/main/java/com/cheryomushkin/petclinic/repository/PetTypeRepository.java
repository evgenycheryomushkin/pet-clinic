package com.cheryomushkin.petclinic.repository;

import com.cheryomushkin.petclinic.domain.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
    PetType findFirstByName(String name);
}
