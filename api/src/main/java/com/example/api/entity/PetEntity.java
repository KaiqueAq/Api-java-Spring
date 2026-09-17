package com.example.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tab_pet")
public class PetEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)

    private String idade;
    @Column(nullable = false)
    private String raca;
    @Column(nullable = false)
    private String porte;

    public PetEntity() {
    }

    public PetEntity(Long id, String nome, String idade, String raca, String porte) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.raca = raca;
        this.porte = porte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }
}
