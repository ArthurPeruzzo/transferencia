package com.projeto.transferencia.usuario.comum;

import com.projeto.transferencia.usuario.comum.record.UsuarioComumRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioComumControllerImplTest {

    @InjectMocks
    private UsuarioComumControllerImpl controller;

    @Mock
    private UsuarioComumServiceImpl service;

    @Test
    public void testSalvar() {
        UsuarioComumRecord usuarioComumRecord = UsuarioComumRecordBase.getUsuarioComumRecord();
        ResponseEntity<?> response = controller.salvar(usuarioComumRecord);

        Mockito.verify(service, Mockito.times(1)).salvar(usuarioComumRecord);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testAtualizar() {
        UsuarioComumRecord usuarioComumRecord = UsuarioComumRecordBase.getUsuarioComumRecord();
        ResponseEntity<?> response = controller.atualizar(usuarioComumRecord);

        Mockito.verify(service, Mockito.times(1)).atualizar(usuarioComumRecord);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testDeletarPorId() {
        Long id = 1L;
        ResponseEntity<?> response = controller.deletarPorId(id);

        Mockito.verify(service, Mockito.times(1)).deletarPorId(id);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}
