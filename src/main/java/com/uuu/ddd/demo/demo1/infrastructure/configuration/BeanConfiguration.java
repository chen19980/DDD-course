package com.uuu.ddd.demo.demo1.infrastructure.configuration;

import com.uuu.ddd.demo.demo1.domain.common.repository.PointTypeRepository;
import com.uuu.ddd.demo.demo1.domain.common.service.PointTypeService;
import com.uuu.ddd.demo.demo1.domain.common.service.PointTypeServiceImpl;
import com.uuu.ddd.demo.demo1.infrastructure.repository.PointTypeDBRepository;
import com.uuu.ddd.demo.demo1.infrastructure.repository.PointTypeMemRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    PointTypeRepository pointTypeRepository() {
        //return new PointTypeMemRepository();
        return new PointTypeDBRepository();
    }
    @Bean
    PointTypeService pointTypeService(PointTypeRepository repository) {
        return new PointTypeServiceImpl(repository);
    }
}
