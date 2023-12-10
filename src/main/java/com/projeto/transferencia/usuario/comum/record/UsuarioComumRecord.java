package com.projeto.transferencia.usuario.comum.record;

import com.projeto.transferencia.usuario.record.UsuarioRecord;
import jakarta.validation.Valid;

public record UsuarioComumRecord(
        Long id,

        @Valid
        UsuarioRecord usuario) {
}
