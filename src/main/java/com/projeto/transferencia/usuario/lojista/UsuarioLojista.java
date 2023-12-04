package com.projeto.transferencia.usuario.lojista;

import com.projeto.transferencia.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario_lojista")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioLojista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario_lojista")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @NotNull(message = "As informações do usuário devem ser preenchidas!")
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
}

