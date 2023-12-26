package com.projeto.transferencia.anotacoes.nomeCompleto;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class NomeCompletoValidatorTest {

    private NomeCompletoValidator validator;
    private ConstraintValidatorContext context;

    @BeforeEach
    void setUp() {
        validator = new NomeCompletoValidator();
        context = mock(ConstraintValidatorContext.class);
    }

    @Test
    void nomeCompletoValido() {
        assertTrue(validator.isValid("John Doe", context));
    }

    @Test
    void nomeCompletoInvalido() {
        assertFalse(validator.isValid("john", context));
    }

    @Test
    void nomeCompletoNulo() {
        assertFalse(validator.isValid(null, context));
    }

    @Test
    void nomeCompletoVazio() {
        assertFalse(validator.isValid("", context));
    }

    @Test
    void deveSerInvalidoSePrimeiroNomeComecarComMinusculo() {
        assertFalse(validator.isValid("john Doe", context));
    }

    @Test
    void deveSerInvalidoSeSegundoNomeComecarComMinusculo() {
        assertFalse(validator.isValid("John doe", context));
    }
}

