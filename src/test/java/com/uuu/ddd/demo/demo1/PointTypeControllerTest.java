package com.uuu.ddd.demo.demo1;

import com.uuu.ddd.demo.demo1.application.rest.PointTypeController;
import com.uuu.ddd.demo.demo1.domain.common.service.PointTypeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PointTypeController.class)
//@WebMvcTest
//@SpringBootTest
public class PointTypeControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    PointTypeService service;

    @Test
    public void mockMvcShouldNotNull() {
        Assertions.assertNotNull(mockMvc);
    }
}
