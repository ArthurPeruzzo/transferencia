package com.projeto.transferencia.usuario.lojista;

import com.projeto.transferencia.usuario.lojista.record.UsuarioLojistaRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioLojistaServiceImplTest {

    @InjectMocks
    private UsuarioLojistaServiceImpl usuarioLojistaService;

    @Mock
    private UsuarioLojistaRepository usuarioLojistaRepository;

    @Test
    public void testSalvar() {
        UsuarioLojistaRecord usuarioLojistaRecord = UsuarioLojistaRecordBase.getUsuarioLojistaRecord();
        assertDoesNotThrow(() -> usuarioLojistaService.salvar(usuarioLojistaRecord));

        verify(usuarioLojistaRepository, Mockito.times(1)).save(any(UsuarioLojista.class));
    }

    @Test
    public void testAtualizar() {
        UsuarioLojistaRecord usuarioLojistaRecord = UsuarioLojistaRecordBase.getUsuarioLojistaRecord();
        assertDoesNotThrow(() -> usuarioLojistaService.atualizar(usuarioLojistaRecord));

        verify(usuarioLojistaRepository, Mockito.times(1)).save(any(UsuarioLojista.class));
    }

    @Test
    public void testDeletarPorId() {
        Long id = 1L;

        assertDoesNotThrow(() -> usuarioLojistaService.deletarPorId(id));

        verify(usuarioLojistaRepository, Mockito.times(1)).deleteById(id);
    }
}
