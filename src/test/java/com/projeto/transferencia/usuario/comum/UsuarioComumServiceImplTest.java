package com.projeto.transferencia.usuario.comum;

import com.projeto.transferencia.usuario.comum.record.UsuarioComumRecord;
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
public class UsuarioComumServiceImplTest {

    @InjectMocks
    private UsuarioComumServiceImpl usuarioComumService;

    @Mock
    private UsuarioComumRepository usuarioComumRepository;

    @Test
    public void testSalvar() {
        UsuarioComumRecord usuarioComumRecord = UsuarioComumRecordBase.getUsuarioComumRecord();
        assertDoesNotThrow(() -> usuarioComumService.salvar(usuarioComumRecord));

        verify(usuarioComumRepository, Mockito.times(1)).save(any(UsuarioComum.class));
    }

    @Test
    public void testAtualizar() {
        UsuarioComumRecord usuarioComumRecord = UsuarioComumRecordBase.getUsuarioComumRecord();
        assertDoesNotThrow(() -> usuarioComumService.atualizar(usuarioComumRecord));

        verify(usuarioComumRepository, Mockito.times(1)).save(any(UsuarioComum.class));
    }

    @Test
    public void testDeletarPorId() {
        Long id = 1L;

        assertDoesNotThrow(() -> usuarioComumService.deletarPorId(id));

        verify(usuarioComumRepository, Mockito.times(1)).deleteById(id);
    }
}
