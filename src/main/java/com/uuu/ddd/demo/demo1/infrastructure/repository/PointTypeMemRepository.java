package com.uuu.ddd.demo.demo1.infrastructure.repository;

import com.uuu.ddd.demo.demo1.domain.PointType;
import com.uuu.ddd.demo.demo1.domain.common.repository.PointTypeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PointTypeMemRepository implements PointTypeRepository {
    private List<PointType> pointTypes = new ArrayList<>();

    @Override
    public Optional<PointType> findById(UUID id) {
        for (PointType pt : pointTypes) {
            if (pt.getTypeId().equals(id)) {
                return Optional.of(pt);
            }
        }
        return Optional.empty();
    }

    @Override
    public UUID save(PointType type) {
        PointType savedPointType = new PointType(UUID.randomUUID(),
                type.getType(), type.getDescription());
        pointTypes.add(savedPointType);
        return savedPointType.getTypeId();
    }

    @Override
    public List<PointType> getAll() {
        return pointTypes;
    }
}
