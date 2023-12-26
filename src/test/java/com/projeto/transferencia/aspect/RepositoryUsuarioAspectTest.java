package com.projeto.transferencia.aspect;

import com.projeto.transferencia.usuario.Usuario;
import com.projeto.transferencia.usuario.comum.UsuarioComum;
import com.projeto.transferencia.usuario.lojista.UsuarioLojista;
import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class RepositoryUsuarioAspectTest {

    @InjectMocks
    private RepositoryUsuarioAspect repositoryUsuarioAspect;

    @Mock
    private ProceedingJoinPoint joinPoint;

    @Test
    public void saveUsuarioComum() throws Throwable {
        UsuarioComum usuarioComum = UsuarioComum.builder()
                .id(1L)
                .usuario(Usuario.builder().identificacao("89976397062").build())
                .build();

        repositoryUsuarioAspect.saveUsuarioComum(joinPoint, usuarioComum);
        verify(joinPoint, times(1)).proceed(any());
    }

    @Test
    public void saveUsuarioLojista() throws Throwable {
        UsuarioLojista usuarioLojista = UsuarioLojista.builder()
                .id(1L)
                .usuario(Usuario.builder().identificacao("89976397062").build())
                .build();

        repositoryUsuarioAspect.saveUsuarioLojista(joinPoint, usuarioLojista);
        verify(joinPoint, times(1)).proceed(any());
    }
}
