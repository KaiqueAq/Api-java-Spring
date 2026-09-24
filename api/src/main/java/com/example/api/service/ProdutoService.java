package com.example.api.service;

import com.example.api.entity.ProdutoEntity;
import com.example.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    //GET
    public List<ProdutoEntity> listarTodosProdutos() {
        return repository.findAll();
    }
//    POST
    public ProdutoEntity salvarProduto(ProdutoEntity produto) {
        if (repository.findByNome(produto.getNome()).isPresent())
            throw new IllegalArgumentException("produto já cadastrado!");

        return repository.save(produto);
    }
//    PUT
    public ProdutoEntity atualizarProduto(Long id, ProdutoEntity produto) {
        if (!repository.existsById(id))
            throw new IllegalArgumentException("produto já cadastrado!");

        produto.setId(id);
        return repository.save(produto);
    }
//    DELETE
    public void deletar(Long id) {
        if (!repository.existsById(id))
            throw new IllegalArgumentException("produto já cadastrado!");
            repository.deleteById(id);
    }
}
