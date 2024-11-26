package com.elevarvendas.technicalTest.mapper.imp;

import com.elevarvendas.technicalTest.mapper.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ModelMapper implements Mapper {
    private org.modelmapper.ModelMapper mapper = new org.modelmapper.ModelMapper();
    @Override
    public <O, D> D convertToObject(O source, Class<D> destination) {
        return mapper.map(source,destination);
    }

    @Override
    public <O, D> List<D> convertToList(List<O> source, Class<D> destination) {
        List<D> list = new ArrayList<>();
        return source.stream().map(x->mapper.map(x,destination)).collect(Collectors.toList());
    }
    //will be used to update
    @Override
    public <O, D> void mapToObject(O source, D destination) {
        mapper.map(source,destination);
    }

}
