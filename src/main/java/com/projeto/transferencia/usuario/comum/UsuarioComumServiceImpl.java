package com.projeto.transferencia.usuario.comum;

import com.projeto.transferencia.usuario.Usuario;
import com.projeto.transferencia.usuario.comum.record.UsuarioComumRecord;
import com.projeto.transferencia.util.modelMapper.ModelMapperRecord;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioComumServiceImpl implements UsuarioComumService {

    private final UsuarioComumRepository repository;

    @Override
    public void salvar(UsuarioComumRecord usuarioComumRecord) {
        UsuarioComum usuarioComum = mapUsuarioComum(usuarioComumRecord);
        repository.save(usuarioComum);
    }

    @Override
    public void atualizar(UsuarioComumRecord usuarioComumRecord) {
        UsuarioComum usuarioComum = mapUsuarioComum(usuarioComumRecord);
        repository.save(usuarioComum);
    }

    @Override
    public void deletarPorId(Long id) {
        repository.deleteById(id);
    }

    private static UsuarioComum mapUsuarioComum(UsuarioComumRecord usuarioComumRecord) {
        ModelMapper modelMapper = ModelMapperRecord.getModelMapperRecord();
        UsuarioComum usuarioComum = modelMapper.map(usuarioComumRecord, UsuarioComum.class);
        Usuario usuario = modelMapper.map(usuarioComumRecord.usuario(), Usuario.class);
        usuarioComum.setUsuario(usuario);
        return usuarioComum;
    }
}
