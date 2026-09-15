package com.example.api.controller;

import com.example.api.entity.ClienteEntity;
import com.example.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public List<ClienteEntity> listarTodos() {
        return repository.findAll();
    }

     @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@RequestBody FuncionarioEntity funcionario) {
        repository.save(funcionario);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Funcionario salvo com sucesso!"));
    }
}
