package com.projeto.transferencia.usuario.record;

import com.projeto.transferencia.anotacoes.cpfCnpj.CpfCnpj;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UsuarioRecord(
        Long id,

        @NotNull(message = "Nome não deve ser nulo!")
        @NotBlank(message = "Nome não deve ser vazio!")
        @Size(max = 60, message = "O nome deve ter no máximo {max} caracteres.")
        String nomeCompleto,

        @NotNull(message = "CPF / CNPJ obrigatório!")
        @CpfCnpj
        String identificacao,

        @NotNull(message = "Email não deve ser nulo!")
        @NotBlank(message = "Email não deve ser vazio!")
        @Size(max = 255, message = "Email deve ter no máximo {max} caracteres.")
        @Email(message = "Email inválido!")
        String email,

        @NotNull(message = "Senha não deve ser nula!")
        @NotBlank(message = "Senha não deve ser vazia!")
        @Size(max = 255, message = "Senha deve ter no máximo {max} caracteres.")
        String senha) {
}
