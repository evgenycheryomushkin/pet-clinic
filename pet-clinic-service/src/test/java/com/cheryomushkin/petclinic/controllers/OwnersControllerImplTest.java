package com.cheryomushkin.petclinic.controllers;

import com.cheryomushkin.petclinic.converters.ConverterImpl;
import com.cheryomushkin.petclinic.converters.OwnersConverter;
import com.cheryomushkin.petclinic.converters.OwnersConverterImpl;
import com.cheryomushkin.petclinic.domain.Owner;
import com.cheryomushkin.petclinic.repository.OwnerRepository;
import com.cheryomushkin.petclinic.transport.owners.AddOwnerDto;
import com.cheryomushkin.petclinic.transport.owners.GetOwnerDto;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SuppressWarnings({
        "initialization.fields.uninitialized",
        "initialization.field.uninitialized"
})
@ExtendWith(MockitoExtension.class)
class OwnersControllerImplTest {

    Owner ownerToReturn;

    @Mock
    OwnerRepository ownerRepository;
    @Spy
    OwnersConverter ownersConverter = new OwnersConverterImpl(new ConverterImpl());
    @Captor
    ArgumentCaptor<Owner> ownerArgumentCaptor;
    @InjectMocks
    OwnersControllerImpl ownersController;

    @BeforeEach
    void beforeEach() {
        ownerToReturn = new Owner(
                "Harry",
                "Potter",
                "0",
                "Koltsovo",
                "0",
                new ArrayList<>());
        ownerToReturn.setId(1L);
    }

    @Test
    void list() {
        when(ownerRepository.findAllByDeletedFalse()).thenReturn(Collections.singletonList(ownerToReturn));
        List<GetOwnerDto> res = ownersController.list();
        assertNotNull(res);
        assertEquals(1, res.size());
        assertEquals(ownerToReturn.getLastName(), res.get(0).getLastName());
    }

    @Test
    void getById() {
        when(ownerRepository.findById(eq(1L))).thenReturn(Optional.of(ownerToReturn));
        @Nullable GetOwnerDto res = ownersController.getById(1L);
        if (res == null) { // checker framework workaround
            fail();
        } else {
            assertEquals(ownerToReturn.getLastName(), res.getLastName());
        }
    }

    @Test
    void getByIdNull() {
        when(ownerRepository.findById(any())).thenReturn(Optional.empty());
        @Nullable GetOwnerDto res = ownersController.getById(2L);
        if (res != null) fail();
    }

    @Test
    void add() {
        when(ownerRepository.save(ownerArgumentCaptor.capture()))
                .thenAnswer(i -> {
                    @NonNull Owner owner = i.getArgument(0);
                    owner.setId(2L);
                    return owner;
                });
        AddOwnerDto addOwnerDto = new AddOwnerDto("Гермиона",
                "Гранджер", "Особняк", "Лондон", "0");
        GetOwnerDto res = ownersController.add(addOwnerDto);
        assertEquals(2L, ownerArgumentCaptor.getValue().ensureId());
        assertEquals(addOwnerDto.getLastName(), ownerArgumentCaptor.getValue().getLastName());
        assertEquals(2L, res.getId());
        assertEquals(addOwnerDto.getLastName(), res.getLastName());
    }
}