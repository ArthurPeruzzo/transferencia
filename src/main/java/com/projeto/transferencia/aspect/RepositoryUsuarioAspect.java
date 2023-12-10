package com.projeto.transferencia.aspect;

import com.projeto.transferencia.usuario.Usuario;
import com.projeto.transferencia.usuario.comum.UsuarioComum;
import com.projeto.transferencia.usuario.lojista.UsuarioLojista;
import com.projeto.transferencia.util.string.StringUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;

@Aspect
@Component
public class RepositoryUsuarioAspect {

    @Around(value = "execution(* com.projeto.transferencia.usuario.comum.UsuarioComumRepository.save(..)) && args(usuarioComum)")
    public Object saveUsuarioComum(ProceedingJoinPoint joinPoint, UsuarioComum usuarioComum) throws Throwable {
        String identificacao = getIdentificacao(usuarioComum, UsuarioComum::getUsuario);
        String identificacaoSemFormatacao = StringUtil.retiraPontoETraco(identificacao);

        Usuario usuario = getUsuario(usuarioComum, UsuarioComum::getUsuario);
        usuario.setIdentificacao(identificacaoSemFormatacao);
        return joinPoint.proceed(new Object[]{usuarioComum});
    }

    @Around(value = "execution(* com.projeto.transferencia.usuario.lojista.UsuarioLojistaRepository.save(..)) && args(usuarioLojista)")
    public Object saveUsuarioLojista(ProceedingJoinPoint joinPoint, UsuarioLojista usuarioLojista) throws Throwable {
        String identificacao = getIdentificacao(usuarioLojista, UsuarioLojista::getUsuario);
        String identificacaoSemFormatacao = StringUtil.retiraPontoETraco(identificacao);

        Usuario usuario = getUsuario(usuarioLojista, UsuarioLojista::getUsuario);
        usuario.setIdentificacao(identificacaoSemFormatacao);
        return joinPoint.proceed(new Object[]{usuarioLojista});
    }

    private static <T> Usuario getUsuario(T usuario, Function<T, Usuario> funcUsuario) {
        return Optional.ofNullable(usuario)
                .map(funcUsuario)
                .orElseThrow(() -> new NoSuchElementException("Usuário é obrigatório!"));
    }

    private static <T> String getIdentificacao(T entity, Function<T, Usuario> funcUsuario) {
        Usuario usuario = getUsuario(entity, funcUsuario);
        return Optional.ofNullable(usuario)
                .map(Usuario::getIdentificacao)
                .orElseThrow(() -> new NoSuchElementException("Identificação é obrigatória!"));
    }

}
