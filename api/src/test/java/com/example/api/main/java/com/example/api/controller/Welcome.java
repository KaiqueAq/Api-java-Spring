package com.example.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Welcome {

    @RequestMapping("/")
    public String mensagem() {
        return "Bem-vindo!";
    }

    @RequestMapping("/dev")
    public String dev() {
        return "Feito por: Carlos";
    }

    @RequestMapping("/turma")
    public String turma() {
        return "número da turma";
    }
    @RequestMapping("/curso")
    public String curso() {
        return "nome do curso ";
    }

}
