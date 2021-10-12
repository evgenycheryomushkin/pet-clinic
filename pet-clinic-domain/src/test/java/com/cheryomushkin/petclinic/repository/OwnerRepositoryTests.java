package com.cheryomushkin.petclinic.repository;

import com.cheryomushkin.petclinic.domain.Owner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OwnerRepositoryTests {

    @Autowired
    OwnerRepository ownerRepository;

    @Test
    public void testCreate() {
        Owner o = new Owner("Гарри", "Поттер");
        ownerRepository.save(o);
    }
}
