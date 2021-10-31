package com.cheryomushkin.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public interface IndexController {
    @RequestMapping("")
    String index();
}
