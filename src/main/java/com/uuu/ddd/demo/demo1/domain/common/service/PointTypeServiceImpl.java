package com.uuu.ddd.demo.demo1.domain.common.service;

import com.uuu.ddd.demo.demo1.domain.PointType;
import com.uuu.ddd.demo.demo1.domain.common.repository.PointTypeRepository;

import java.util.List;
import java.util.UUID;

public class PointTypeServiceImpl implements PointTypeService {
    public PointTypeServiceImpl(PointTypeRepository repository) {
        this.repository = repository;
    }

    private PointTypeRepository repository;


    @Override
    public UUID createPointType(PointType type) {
        UUID id = repository.save(type);
        return id;
    }

    @Override
    public List<PointType> allTypes() {
        return repository.getAll();
    }
}
