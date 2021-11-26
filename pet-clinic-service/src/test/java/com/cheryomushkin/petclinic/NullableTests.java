package com.cheryomushkin.petclinic;

import com.cheryomushkin.petclinic.transport.pets.UpdatePetDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
@Slf4j
public class NullableTests {
    @Test
    public void testNullableUpdatePetDto() {
        // todo move to checker framework
        UpdatePetDto updatePetDto = UpdatePetDto.builder().birthDate(LocalDate.now()).build();
        log.info("updatePetDto {}", updatePetDto);
    }
}
