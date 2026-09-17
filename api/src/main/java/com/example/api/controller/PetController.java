package com.example.api.controller;

import com.example.api.entity.PetEntity;
import com.example.api.entity.UsuarioEntity;
import com.example.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetRepository repository;

    @GetMapping
    public List<PetEntity> listTodos() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@RequestBody PetEntity pet) {
        repository.save(pet);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Pet Criado"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar(@PathVariable Long id, @RequestBody PetEntity pet) {
        if (!repository.existsById(id)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of("mensagem", "Pet não encontrado"));
        }

        pet.setId(id);
        repository.save(pet);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Pet autalizado"));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> Deletar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of("mensagem", "não encontrou pet"));
        }

        repository.deleteById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Pet deletado"));
    }
}
