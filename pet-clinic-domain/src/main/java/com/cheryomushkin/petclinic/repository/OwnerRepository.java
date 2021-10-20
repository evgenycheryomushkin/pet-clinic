package com.cheryomushkin.petclinic.repository;

import com.cheryomushkin.petclinic.domain.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
