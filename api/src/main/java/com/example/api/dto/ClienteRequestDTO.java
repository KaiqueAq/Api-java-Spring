package com.example.api.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClienteRequestDTO {
    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, message = "O nome deve ter no mínimo 3 caracteres.")
    private String nome;

    @NotBlank(message = "O nome é obrigatório")
    @Email(message = "Deve ser um e-mail válido.")
    @Size(max = 200, message = "O e-mail deve ter no máximo 200 caracteres.")
    private String email;

    @NotBlank(message = "O telefone é obrigatório.")
    @Size(min = 11, max = 15, message = "O telefone deve ter entre 11 e 15 caracteres.")
    private String telefone;

}
