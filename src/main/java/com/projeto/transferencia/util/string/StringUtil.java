package com.projeto.transferencia.util.string;

public class StringUtil {

    public static String retiraPontoETraco(String valor) {
        if (valor == null || valor.isEmpty() || valor.isBlank()) {
            throw new IllegalArgumentException("O valor não pode ser nulo!");
        }
        return valor.replaceAll("[.-]", "");
    }
}
