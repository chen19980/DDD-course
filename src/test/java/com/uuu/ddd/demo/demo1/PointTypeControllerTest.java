package com.uuu.ddd.demo.demo1;

import com.uuu.ddd.demo.demo1.application.rest.PointTypeController;
import com.uuu.ddd.demo.demo1.domain.common.service.PointTypeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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

    @Test
    public void hasValidEndPoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/points/list").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void hasMoreValidEndPoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/points/list").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    public void hasInvalidEndPoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/list").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void hasMoreInvalidEndPoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/list").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
}
