package com.projeto.transferencia.usuario.lojista;

import com.projeto.transferencia.usuario.lojista.record.UsuarioLojistaRecord;
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
public class UsuarioLojistaControllerImplTest {

    @InjectMocks
    private UsuarioLojistaControllerImpl controller;

    @Mock
    private UsuarioLojistaServiceImpl service;

    @Test
    public void testSalvar() {
        UsuarioLojistaRecord usuarioLojistaRecord = UsuarioLojistaRecordBase.getUsuarioLojistaRecord();
        ResponseEntity<?> response = controller.salvar(usuarioLojistaRecord);

        Mockito.verify(service, Mockito.times(1)).salvar(usuarioLojistaRecord);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testAtualizar() {
        UsuarioLojistaRecord usuarioLojistaRecord = UsuarioLojistaRecordBase.getUsuarioLojistaRecord();
        ResponseEntity<?> response = controller.atualizar(usuarioLojistaRecord);

        Mockito.verify(service, Mockito.times(1)).atualizar(usuarioLojistaRecord);
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
