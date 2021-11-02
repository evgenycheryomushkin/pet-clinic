package com.cheryomushkin.petclinic.controllers;

import com.cheryomushkin.petclinic.controller.OwnerController;
import com.cheryomushkin.petclinic.converters.Converter;
import com.cheryomushkin.petclinic.domain.Owner;
import com.cheryomushkin.petclinic.repository.OwnerRepository;
import com.cheryomushkin.petclinic.transport.OwnerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
public class OwnerControllerImpl implements OwnerController {
    private final OwnerRepository ownerRepository;
    private final Converter converter;

    public String owners(Model model) {
        Iterable<Owner> owners = ownerRepository.findAll();
        Iterable<OwnerDto> ownerDtos = converter.mapOwners(owners);
        model.addAttribute("owners", ownerDtos);
        return "owners/index";
    }
}
