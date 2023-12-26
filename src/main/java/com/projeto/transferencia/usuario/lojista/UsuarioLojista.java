package com.projeto.transferencia.usuario.lojista;

import com.projeto.transferencia.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario_lojista")
@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class UsuarioLojista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario_lojista")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
}

