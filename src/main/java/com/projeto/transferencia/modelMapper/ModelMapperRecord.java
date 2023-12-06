package com.projeto.transferencia.modelMapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.record.RecordModule;

public class ModelMapperRecord {

    private static ModelMapper modelMapper;

    private ModelMapperRecord() {
    }

    public static ModelMapper getModelMapperRecord() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
            modelMapper.registerModule(new RecordModule());
        }
        return modelMapper;
    }
}
