package com.uuu.ddd.demo.demo1;

import com.uuu.ddd.demo.demo1.domain.PointType;
import com.uuu.ddd.demo.demo1.domain.common.repository.PointTypeRepository;
import com.uuu.ddd.demo.demo1.domain.common.service.PointTypeService;
import com.uuu.ddd.demo.demo1.domain.common.service.PointTypeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.UUID;

public class Domain1Tests {
    private PointTypeRepository repository;
    private PointTypeService service;

    @BeforeEach
    public void setUp() {
        System.out.println("prepare, create service instance");
        repository = Mockito.mock(PointTypeRepository.class);
        Mockito.when(repository.save(ArgumentMatchers.any(PointType.class)))
                .thenReturn(UUID.randomUUID());
        service = new PointTypeServiceImpl(repository);
    }

    @Test
    public void doTest1() {
        PointType type = new PointType("type1", "description 1");
        service.createPointType(type);
        Mockito.verify(repository).save(ArgumentMatchers.any(PointType.class));
    }

    @Test
    public void doTest2() {
        PointType type = new PointType("type1", "description 1");
        //service.createPointType(type);
        //Mockito.verify(repository).save(ArgumentMatchers.any(PointType.class));
    }

    @Test
    public void doTest3() {
        PointType type1 = new PointType("type1", "description 1");
        PointType type2 = new PointType("type2", "description 2");
        PointType type3 = new PointType("type3", "description 3");
        PointType type4 = new PointType("type4", "description 4");
        service.createPointType(type1);
        service.createPointType(type2);
        service.createPointType(type3);
        service.createPointType(type4);
        Mockito.verify(repository, Mockito.times(4)).save(ArgumentMatchers.any(PointType.class));
    }


    @Test
    public void doTestx() {
        PointType type = new PointType("type2", "description 2");
        UUID id = service.createPointType(type);
        System.out.println("UUID=" + id);
        System.out.println("this is test1");
        Assertions.assertNotNull(id);


    }
}
