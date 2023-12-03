package com.projeto.transferencia.usuario.lojista;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioLojistaServiceImpl implements UsuarioLojistaService {

    private final UsuarioLojistaRepository repository;

    @Override
    public UsuarioLojista salvar(UsuarioLojista usuarioLojista) {
        return repository.save(usuarioLojista);
    }

    @Override
    public UsuarioLojista atualizar(UsuarioLojista usuarioLojista) {
        return repository.save(usuarioLojista);
    }

    @Override
    public void deletarPorId(Long id) {
        repository.deleteById(id);
    }
}
