package com.projeto.transferencia.usuario;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "usuario")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @NotNull
    @Size(max = 60)
    @Column(name = "nome_completo")
    private String nomeCompleto;

    @NotNull
    @Size(min = 11, max = 14)
    @Column(name = "identificacao", unique = true)
    private String identificacao;

    @NotNull
    @Size(max = 255)
    @Email(message = "Email inválido!")
    @Column(name = "email", unique = true)
    private String email;

    @NotNull
    @Size(max = 255)
    @Column(name = "senha")
    private String senha;
}
