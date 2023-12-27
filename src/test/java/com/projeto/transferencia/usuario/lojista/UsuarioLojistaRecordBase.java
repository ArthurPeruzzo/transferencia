package com.projeto.transferencia.usuario.lojista;

import com.projeto.transferencia.usuario.lojista.record.UsuarioLojistaRecord;
import com.projeto.transferencia.usuario.record.UsuarioRecord;

public class UsuarioLojistaRecordBase {

    public static UsuarioLojistaRecord getUsuarioLojistaRecord() {
        return new UsuarioLojistaRecord(1L, new UsuarioRecord(2L, "Teste Teste", "92572673002", "teste@gmail.com", "93721"));
    }
}
