package com.projeto.transferencia.anotacoes.cpfCnpj;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

public class CpfCnpjValidator implements ConstraintValidator<CpfCnpj, String> {

    @Override
    public void initialize(CpfCnpj cpfCnpj) {
    }

    @Override
    public boolean isValid(String cpfCnpj, ConstraintValidatorContext context) {
       return isCpf(cpfCnpj, context) || isCnpj(cpfCnpj, context);
    }

    private static boolean isCpf(String cpfCnpj, ConstraintValidatorContext context) {
        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);

        return cpfValidator.isValid(cpfCnpj, context);
    }

    private static boolean isCnpj(String cpfCnpj, ConstraintValidatorContext context) {
        CNPJValidator cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);

        return cnpjValidator.isValid(cpfCnpj, context);
    }
}
