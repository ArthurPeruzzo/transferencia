package com.projeto.transferencia.util;

import com.projeto.transferencia.util.modelMapper.ModelMapperRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.record.RecordValueReader;

public class ModelMapperRecordTest {

    @Test
    public void deveRetornarMesmaInstancia() {
        ModelMapper primeiraInstancia = ModelMapperRecord.getModelMapperRecord();
        ModelMapper segundaInstancia = ModelMapperRecord.getModelMapperRecord();

        Assertions.assertSame(primeiraInstancia, segundaInstancia);
    }

    @Test
    public void deveRegistrarRecordModule() {
        ModelMapper modelMapper = ModelMapperRecord.getModelMapperRecord();

        Assertions.assertTrue(modelMapper.getConfiguration().getValueReaders()
                .stream().anyMatch(RecordValueReader.class::isInstance));
    }
}
