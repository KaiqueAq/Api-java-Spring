package com.example.api.controller;

import com.example.api.entity.FuncionarioEntity;
import com.example.api.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioRepository repository;

    @GetMapping
    public List<FuncionarioEntity> listTodos() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<FuncionarioEntity> salvar(@RequestBody FuncionarioEntity funcionario) {
        repository.save(funcionario);
        return ResponseEntity.created(null).body(funcionario);
    }
}
