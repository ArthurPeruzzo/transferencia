package com.projeto.transferencia.usuario.comum;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioComumServiceImpl implements UsuarioComumService {

    private final UsuarioComumRepository repository;

    @Override
    public UsuarioComum salvar(UsuarioComum usuarioComum) {
       return repository.save(usuarioComum);
    }

    @Override
    public UsuarioComum atualizar(UsuarioComum usuarioComum) {
        return repository.save(usuarioComum);
    }

    @Override
    public void deletarPorId(Long id) {
        repository.deleteById(id);
    }
}
