package com.projeto.transferencia.usuario.lojista.record;

import com.projeto.transferencia.usuario.record.UsuarioRecord;
import jakarta.validation.Valid;

public record UsuarioLojistaRecord(
        Long id,

        @Valid
        UsuarioRecord usuario) {
}
