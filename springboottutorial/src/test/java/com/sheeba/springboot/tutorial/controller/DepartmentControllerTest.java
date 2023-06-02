package com.sheeba.springboot.tutorial.controller;

import com.sheeba.springboot.tutorial.entity.Department;
import com.sheeba.springboot.tutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;


    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentId(1L)
                .departmentName("IT")
                .departmentCode("IT-06")
                .departmentAddress("Bangalore")
                .build();
    }

    @Test
    void saveDepartment() throws  Exception{
        Department inputDepartment = Department.builder()
                .departmentName("IT")
                .departmentCode("IT-06")
                .departmentAddress("Bangalore")
                .build();
        Mockito.when(departmentService.saveDepartment(department)).thenReturn(department);
        mockMvc.perform(post("/department")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"departmentName\":\"IT\",\n" +
                        "\"departmentAddress\":\"Bangalore\",\n" +
                        "\"departmentCode\":\"IT-06\"}"))
                .andExpect(status().isOk());
    }

    @Test
    void getDepartmentByID() {
    }
}