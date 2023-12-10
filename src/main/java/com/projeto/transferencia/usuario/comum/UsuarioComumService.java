package com.projeto.transferencia.usuario.comum;

import com.projeto.transferencia.usuario.comum.record.UsuarioComumRecord;

public interface UsuarioComumService {

    void salvar(UsuarioComumRecord usuarioComum);
    void atualizar(UsuarioComumRecord usuarioComumRecord);
    void deletarPorId(Long id);
}
