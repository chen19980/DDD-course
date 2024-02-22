package com.uuu.ddd.demo.demo1;

import com.uuu.ddd.demo.demo1.domain.PointType;
import com.uuu.ddd.demo.demo1.infrastructure.repository.PointTypeJPARepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class PointTypeJPARepositoryTest {
    @Autowired
    private PointTypeJPARepository repository;

    @BeforeEach
    void clearEachStep() {
        System.out.println("清空重作");
        repository.deleteAll();
    }

    @Test
    void repositoryNotNull() {
        Assertions.assertNotNull(repository);
    }

    @Test
    void savePointType1() {
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
