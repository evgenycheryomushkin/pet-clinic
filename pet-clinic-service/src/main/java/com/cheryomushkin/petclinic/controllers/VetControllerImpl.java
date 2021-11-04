package com.cheryomushkin.petclinic.controllers;

import com.cheryomushkin.petclinic.controller.VetController;
import com.cheryomushkin.petclinic.converters.Converter;
import com.cheryomushkin.petclinic.domain.Vet;
import com.cheryomushkin.petclinic.repository.VetRepository;
import com.cheryomushkin.petclinic.transport.VetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
public class VetControllerImpl implements VetController {
    final Converter converter;
    final VetRepository vetRepository;

    public String vets(Model model) {
        Iterable<Vet> vets = vetRepository.findAll();
        Iterable<VetDto> vetDtos = converter.mapVets(vets);
        model.addAttribute("vets", vetDtos);
        return "vets/index";
    }
}
