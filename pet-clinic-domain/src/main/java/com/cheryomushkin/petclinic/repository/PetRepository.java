package com.cheryomushkin.petclinic.repository;

import com.cheryomushkin.petclinic.domain.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
