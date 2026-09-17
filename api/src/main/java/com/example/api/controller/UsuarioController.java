package com.example.api.controller;

import com.example.api.entity.UsuarioEntity;
import com.example.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public List<UsuarioEntity> listTodos() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@RequestBody UsuarioEntity usuario) {
        repository.save(usuario);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "deu certo"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar(@PathVariable Long id, @RequestBody UsuarioEntity usuario) {
        if (!repository.existsById(id)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of("mensagem", "usuarios não encontrado"));
        }

        usuario.setId(id);
        repository.save(usuario);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "usuarios Atualizado"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of("mensagem", "usuarios não encontrado"));

        }
        repository.deleteById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "usuarios deletado"));
    }
}
