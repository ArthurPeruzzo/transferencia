package com.projeto.transferencia.anotacoes.cpfCnpj;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class CpfCnpjValidatorTest {

    private CpfCnpjValidator validator;
    private ConstraintValidatorContext context;

    @BeforeEach
    void setUp() {
        validator = new CpfCnpjValidator();
        context = mock(ConstraintValidatorContext.class);
    }

    @Test
    void testeCpfValido() {
        assertTrue(validator.isValid("925.726.730-02", context));
    }

    @Test
    void testeCnpjValido() {
        assertTrue(validator.isValid("105.174.600-09", context));
    }

    @Test
    void testeCnpjECpfInvalido() {
        assertFalse(validator.isValid("12344", context));
    }

    @Test
    void testeCpfInvalido() {
        assertFalse(validator.isValid("12345678901", context));
    }

    @Test
    void testeCnpjInvalido() {
        assertFalse(validator.isValid("12345678000122", context));
    }
}

