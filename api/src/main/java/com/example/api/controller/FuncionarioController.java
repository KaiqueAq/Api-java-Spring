package com.example.api.controller;

import com.example.api.entity.FuncionarioEntity;
import com.example.api.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioService service;

    @GetMapping
    public List<FuncionarioEntity> listTodos() {
        return service.listTodosFuncionario();
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> salvar(@RequestBody FuncionarioEntity cliente){
        service.salvarFuncionario(cliente);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem","Cliente salvo com sucesso!"));
    }
}
