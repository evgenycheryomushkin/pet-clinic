package com.cheryomushkin.petclinic.controllers;

import com.cheryomushkin.petclinic.controller.IndexController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexControllerImpl implements IndexController {
    @RequestMapping("")
    public String index() {
        return "index";
    }
}
