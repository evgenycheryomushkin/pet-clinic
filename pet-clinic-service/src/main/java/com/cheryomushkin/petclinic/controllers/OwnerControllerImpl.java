package com.cheryomushkin.petclinic.controllers;

import com.cheryomushkin.petclinic.controller.OwnerController;
import org.springframework.stereotype.Controller;

@Controller
public class OwnerControllerImpl implements OwnerController {
    public String owners() {
        return "owners/index";
    }
}
