package br.com.diegofrazao.desafio_control.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String redirectIndex() {
        return "redirect:home";
    }

    @GetMapping("/home")
    public String showIndex(){
        return "home";
    }
}
