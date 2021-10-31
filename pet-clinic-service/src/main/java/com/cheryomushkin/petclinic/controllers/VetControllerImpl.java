package com.cheryomushkin.petclinic.controllers;

import com.cheryomushkin.petclinic.controller.VetController;
import org.springframework.stereotype.Controller;

@Controller
public class VetControllerImpl implements VetController {
    public String vets() {
        return "vets/index";
    }
}
