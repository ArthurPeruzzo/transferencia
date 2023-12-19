package com.projeto.transferencia.util;

import com.projeto.transferencia.util.string.StringUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringUtilTest {

    @Test
    public void deveRetirarPontoETracoDeString() {
        String valor = "473.982.374-89";
        String valorEsperado = "47398237489";
        String valorFormatado = StringUtil.retiraPontoETraco(valor);
        Assertions.assertEquals(valorFormatado, valorEsperado);
    }

    @Test
    public void deveRetornarIllegalArgumentExceptionSeValorVazio() {
        String valor = "";
        Assertions.assertThrows(IllegalArgumentException.class, ()-> StringUtil.retiraPontoETraco(valor));
    }

    @Test
    public void deveRetornarIllegalArgumentExceptionSeValorNulo() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> StringUtil.retiraPontoETraco(null));
    }

    @Test
    public void deveRetornarIllegalArgumentExceptionSeValorBranco() {
        String valor = "  ";
        Assertions.assertThrows(IllegalArgumentException.class, ()-> StringUtil.retiraPontoETraco(valor));
    }
}
