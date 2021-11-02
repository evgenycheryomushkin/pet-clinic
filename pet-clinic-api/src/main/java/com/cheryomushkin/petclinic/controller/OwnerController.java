package com.cheryomushkin.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public interface OwnerController {
    @RequestMapping("")
    String owners(Model model);
}
