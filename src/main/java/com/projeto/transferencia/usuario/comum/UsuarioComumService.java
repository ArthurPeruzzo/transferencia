package com.projeto.transferencia.usuario.comum;

public interface UsuarioComumService {

    UsuarioComum salvar(UsuarioComum usuarioComum);
    UsuarioComum atualizar(UsuarioComum usuarioComum);
    void deletarPorId(Long id);
}
