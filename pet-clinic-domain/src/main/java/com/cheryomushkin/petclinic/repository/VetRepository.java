package com.cheryomushkin.petclinic.repository;

import com.cheryomushkin.petclinic.domain.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
