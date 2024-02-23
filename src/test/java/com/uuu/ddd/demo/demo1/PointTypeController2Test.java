package com.uuu.ddd.demo.demo1;

import com.uuu.ddd.demo.demo1.application.rest.PointTypeController;
import com.uuu.ddd.demo.demo1.domain.PointType;
import com.uuu.ddd.demo.demo1.domain.common.service.PointTypeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;

@WebMvcTest(PointTypeController.class)
public class PointTypeController2Test {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    PointTypeService service;

    @Test
    public void validEndpointCheck() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/points/list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                //.andExpect(MockMvcResultMatchers.jsonPath("$.employees",hasSize(0)));
                .andExpect(MockMvcResultMatchers.jsonPath("$.pointTypes", hasSize(0)));
    }

    @Test
    public void inserSomeDataAndCheck() throws Exception {
        PointType t1 = new PointType("type1", "description1");
        PointType t2 = new PointType("type2", "description2");
        PointType t3 = new PointType("type3", "description3");
        List<PointType> records = new ArrayList<>(Arrays.asList(t1, t2, t3));
        Mockito.when(service.allTypes()).thenReturn(records);
        mockMvc.perform(MockMvcRequestBuilders.get("/points/list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.pointTypes", hasSize(3)));
    }
}
