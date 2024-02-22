package com.uuu.ddd.demo.demo1;

import com.uuu.ddd.demo.demo1.domain.PointType;
import com.uuu.ddd.demo.demo1.infrastructure.repository.PointTypeJPARepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

//@SpringBootTest
@DataJpaTest
public class PointTypeJPARepository2Test {
    @Autowired
    private PointTypeJPARepository repository;


    @Test
    void repositoryNotNull() {
        Assertions.assertNotNull(repository);
    }

    @Test
    void savePointType() {
        PointType pt = repository.save(new PointType("sample1", "sample descriptions"));
        Optional<PointType> byId = repository.findById(pt.getTypeId());
        System.out.println("result=" + byId.get().toString());
        System.out.println("目前有?個entity?" + repository.count());
        Assertions.assertEquals(repository.count(), 1);

    }
    @Test
    void savePointType2() {
        PointType pt = repository.save(new PointType("sample2", "more descriptions"));
        PointType pt2 = repository.save(new PointType("sample3", "more descriptions..."));
        Optional<PointType> byId = repository.findById(pt.getTypeId());
        System.out.println("result=" + byId.get().toString());
        System.out.println("目前有?個entity?" + repository.count());
        Assertions.assertEquals(repository.count(), 2);

    }


}
