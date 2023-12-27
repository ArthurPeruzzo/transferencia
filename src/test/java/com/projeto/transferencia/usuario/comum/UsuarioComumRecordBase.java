package com.projeto.transferencia.usuario.comum;

import com.projeto.transferencia.usuario.comum.record.UsuarioComumRecord;
import com.projeto.transferencia.usuario.record.UsuarioRecord;

public class UsuarioComumRecordBase {

    public static UsuarioComumRecord getUsuarioComumRecord() {
        return new UsuarioComumRecord(1L, new UsuarioRecord(2L, "Teste Teste", "92572673002", "teste@gmail.com", "93721"));
    }
}
