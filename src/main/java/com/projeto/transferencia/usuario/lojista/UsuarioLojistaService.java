package com.projeto.transferencia.usuario.lojista;

import com.projeto.transferencia.usuario.lojista.record.UsuarioLojistaRecord;

public interface UsuarioLojistaService {

    UsuarioLojista salvar(UsuarioLojistaRecord usuarioLojista);
    UsuarioLojista atualizar(UsuarioLojista usuarioLojista);
    void deletarPorId(Long id);
}
