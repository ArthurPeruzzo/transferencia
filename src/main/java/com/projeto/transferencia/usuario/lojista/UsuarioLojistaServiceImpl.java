package com.projeto.transferencia.usuario.lojista;

import com.projeto.transferencia.usuario.Usuario;
import com.projeto.transferencia.usuario.lojista.record.UsuarioLojistaRecord;
import com.projeto.transferencia.util.modelMapper.ModelMapperRecord;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioLojistaServiceImpl implements UsuarioLojistaService {

    private final UsuarioLojistaRepository repository;

    @Override
    public UsuarioLojista salvar(UsuarioLojistaRecord usuarioLojistaRecord) {
        UsuarioLojista usuarioLojista = mapUsuarioLojista(usuarioLojistaRecord);
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

    private static UsuarioLojista mapUsuarioLojista(UsuarioLojistaRecord usuariolojistaRecord) {
        ModelMapper modelMapper = ModelMapperRecord.getModelMapperRecord();
        UsuarioLojista usuarioLojista = modelMapper.map(usuariolojistaRecord, UsuarioLojista.class);
        Usuario usuario = modelMapper.map(usuariolojistaRecord.usuario(), Usuario.class);
        usuarioLojista.setUsuario(usuario);
        return usuarioLojista;
    }
}
