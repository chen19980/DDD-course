package com.uuu.ddd.demo.demo1;

import com.uuu.ddd.demo.demo1.domain.PointType;
import com.uuu.ddd.demo.demo1.infrastructure.repository.PointTypeJPARepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class PointTypeJPARepository3Test {
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
        repository.save(new PointType("sample1", "desc1"));
        repository.save(new PointType("sample1", "desc2"));
        repository.save(new PointType("sample2", "desc1"));
        repository.save(new PointType("sample2", "desc2"));
        System.out.println("now we have ?? point type?" + repository.count());
        List<PointType> sample1 = repository.findByType("sample1");
        for (PointType t : sample1) {
            System.out.println("type=" + t.getType() + " ,description=" + t.getDescription());
        }
        List<PointType> desc2 = repository.findByDescription("desc2");
        for (PointType t:desc2) {
            System.out.println("[find desc2 in repository]:type=" + t.getType() + " ,description=" + t.getDescription());
        }

    }


}
