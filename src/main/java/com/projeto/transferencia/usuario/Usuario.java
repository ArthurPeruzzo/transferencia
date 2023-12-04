package com.projeto.transferencia.usuario;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "usuario", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"identificacao", "email"}),
})
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @NotNull(message = "Nome não deve ser nulo!")
    @NotBlank(message = "Nome não deve ser vazio!")
    @Size(max = 60, message = "O nome deve ter no máximo {max} caracteres.")
    @Column(name = "nome_completo", nullable = false)
    private String nomeCompleto;

    @NotNull(message = "Identificação não deve ser nula!")
    @NotBlank(message = "Identificação não deve ser vazia!")
    @Size(min = 11, max = 14, message = "O tamanho da identificação deve ter entre {min} e {max} caracteres.")
    @Column(name = "identificacao", unique = true, nullable = false)
    private String identificacao;

    @NotNull(message = "Email não deve ser nulo!")
    @Size(max = 255, message = "Email deve ter no máximo {max} caracteres.")
    @Email(message = "Email inválido!")
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @NotNull(message = "Senha não deve ser nula!")
    @NotBlank(message = "Senha não deve ser vazia!")
    @Size(max = 255, message = "Senha deve ter no máximo {max} caracteres.")
    @Column(name = "senha", nullable = false)
    private String senha;
}
