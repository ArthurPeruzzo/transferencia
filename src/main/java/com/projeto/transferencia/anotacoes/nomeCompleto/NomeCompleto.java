package com.projeto.transferencia.anotacoes.nomeCompleto;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NomeCompletoValidator.class)
public @interface NomeCompleto {
    String message() default "Nome completo inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
