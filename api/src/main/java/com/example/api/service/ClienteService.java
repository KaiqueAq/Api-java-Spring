package com.example.api.service;

import com.example.api.dto.ClienteRequestDTO;
import com.example.api.dto.ClienteResponseDTO;
import com.example.api.entity.ClienteEntity;
import com.example.api.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository repository;


    public List<ClienteResponseDTO> listarTodosClientes() {
        return repository
                .findAll()
                .stream()
                .map(c -> new ClienteResponseDTO(c.getNome(), c.getEmail()))
                .toList();
    }

    public ClienteEntity salvarClientes(@Valid ClienteRequestDTO dto) {
        if (repository.findByNome(dto.getNome()).isPresent())
            throw new IllegalArgumentException("Cliente já existe");


        ClienteEntity novoCliente = new ClienteEntity();
        novoCliente.setNome(dto.getNome());
        novoCliente.setEmail(dto.getEmail());
        novoCliente.setTelefone(dto.getTelefone());
        return repository.save(novoCliente);
    }

    public ClienteEntity atualizarCliente(Long id, @Valid ClienteRequestDTO dto) {

        ClienteEntity clienteExistente = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        clienteExistente.setNome(dto.getNome());
        clienteExistente.setEmail(dto.getEmail());
        clienteExistente.setTelefone(dto.getTelefone());
        return repository.save(clienteExistente);
    }


    public void deletarCliente(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Cliente não encontrado");
        }
        repository.deleteById(id);
    }
}
