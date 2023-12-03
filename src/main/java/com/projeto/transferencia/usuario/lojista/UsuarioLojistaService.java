package com.projeto.transferencia.usuario.lojista;

public interface UsuarioLojistaService {

    UsuarioLojista salvar(UsuarioLojista usuarioLojista);
    UsuarioLojista atualizar(UsuarioLojista usuarioLojista);
    void deletarPorId(Long id);
}
