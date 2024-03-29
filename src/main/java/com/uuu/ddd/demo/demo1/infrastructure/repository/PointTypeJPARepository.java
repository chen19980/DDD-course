package com.uuu.ddd.demo.demo1.infrastructure.repository;

import com.uuu.ddd.demo.demo1.domain.PointType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PointTypeJPARepository extends JpaRepository<PointType, UUID> {
    List<PointType>  findByType(String type);
    List<PointType> findByDescription(String description);
}
