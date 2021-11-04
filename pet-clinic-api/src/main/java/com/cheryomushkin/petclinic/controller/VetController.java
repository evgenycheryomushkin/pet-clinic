package com.cheryomushkin.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vets")
public interface VetController {
    @RequestMapping("")
    String vets(Model model);
}
