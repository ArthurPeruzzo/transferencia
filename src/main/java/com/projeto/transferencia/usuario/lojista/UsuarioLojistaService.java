package com.projeto.transferencia.usuario.lojista;

import com.projeto.transferencia.usuario.lojista.record.UsuarioLojistaRecord;

public interface UsuarioLojistaService {

    void salvar(UsuarioLojistaRecord usuarioLojista);
    void atualizar(UsuarioLojistaRecord usuarioLojistaRecord);
    void deletarPorId(Long id);
}
