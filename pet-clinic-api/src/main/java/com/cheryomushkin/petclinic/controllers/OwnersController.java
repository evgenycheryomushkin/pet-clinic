package com.cheryomushkin.petclinic.controllers;

import com.cheryomushkin.petclinic.transport.owners.AddOwnerDto;
import com.cheryomushkin.petclinic.transport.owners.GetOwnerDto;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/petclinic/api/owners")
@Validated
public interface OwnersController {
    @GetMapping("")
    List<GetOwnerDto> list();
    @GetMapping("/{id}")
    @Nullable GetOwnerDto getById(@PathVariable Long id);
    @PostMapping("")
    GetOwnerDto add(@RequestBody @Valid AddOwnerDto ownerDto);
    @PutMapping("/{id}")
    void update(@PathVariable Long id, @RequestBody @Valid AddOwnerDto addOwnerDto);
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);
    @GetMapping("/*/lastname/{start}")
    Iterable<GetOwnerDto> findByLastnameStart(@PathVariable String start);
}
