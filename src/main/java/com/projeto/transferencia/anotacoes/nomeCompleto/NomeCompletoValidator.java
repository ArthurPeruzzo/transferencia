package com.projeto.transferencia.anotacoes.nomeCompleto;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NomeCompletoValidator implements ConstraintValidator<NomeCompleto, String> {

    @Override
    public boolean isValid(String nomeCompleto, ConstraintValidatorContext constraintValidatorContext) {
        if (nomeCompleto == null || nomeCompleto.trim().isEmpty()) {
            return false;
        }

        String[] partesNome = divideNomeCompletoEmPartes(nomeCompleto);

        if (partesNome.length < 2) {
            return false;
        }

        return verificaSeNomeSobrenomeComecaComMaiusculo(partesNome);
    }

    private static String[] divideNomeCompletoEmPartes(String nomeCompleto) {
        return nomeCompleto.split("\\s+");
    }

    private boolean verificaSeNomeSobrenomeComecaComMaiusculo(String[] partesNome) {
        for (String parte : partesNome) {
            if (!iniciaComMaiuscula(parte)) {
                return false;
            }
        }
        return true;
    }

    private static boolean iniciaComMaiuscula(String parte) {
        Pattern pattern = Pattern.compile("^[A-ZÀ-Ú][a-zà-ú]*$");
        Matcher matcher = pattern.matcher(parte);
        return matcher.matches();
    }
}
