package com.projeto.transferencia.util.string;

public class StringUtil {

    public static String retiraPontoETraco(String valor) {
        if (valor == null || valor.isEmpty() || valor.isBlank()) {
            return valor;
        }
        return valor.replaceAll("[.-]", "");
    }
}
