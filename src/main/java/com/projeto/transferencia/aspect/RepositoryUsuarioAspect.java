package com.projeto.transferencia.aspect;

import com.projeto.transferencia.usuario.Usuario;
import com.projeto.transferencia.usuario.comum.UsuarioComum;
import com.projeto.transferencia.util.string.StringUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Optional;

@Aspect
@Component
public class RepositoryUsuarioAspect {

    @Around(value = "execution(* com.projeto.transferencia.usuario.comum.UsuarioComumRepository.save(..)) && args(usuarioComum)")
    public Object saveUsuarioComum(ProceedingJoinPoint joinPoint, UsuarioComum usuarioComum) throws Throwable {
        String identificacao = getIdentificacao(usuarioComum);
        String identificacaoSemFormatacao = StringUtil.retiraPontoETraco(identificacao);

        Usuario usuario = getUsuario(usuarioComum);
        usuario.setIdentificacao(identificacaoSemFormatacao);
        return joinPoint.proceed(new Object[]{usuarioComum});
    }

    private static String getIdentificacao(UsuarioComum usuarioComum) {
        Usuario usuario = getUsuario(usuarioComum);

        return Optional.of(usuario)
                .map(Usuario::getIdentificacao)
                .orElseThrow(()-> new NoSuchElementException("Identificação é obrigatória!"));
    }

    private static Usuario getUsuario(UsuarioComum usuarioComum) {
        return Optional.of(usuarioComum)
                .map(UsuarioComum::getUsuario)
                .orElseThrow(() -> new NoSuchElementException("Usuário é obrigatório!"));
    }
}
