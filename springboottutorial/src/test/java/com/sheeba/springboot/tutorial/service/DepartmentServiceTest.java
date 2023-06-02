package com.sheeba.springboot.tutorial.service;

import com.sheeba.springboot.tutorial.entity.Department;
import com.sheeba.springboot.tutorial.repository.DepartmentRepository;
import jakarta.persistence.Access;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().departmentName("IT")
                .departmentAddress("Ahmedabad")
                .departmentCode("IT06")
                .departmentId(1L).build();
        Mockito.when(departmentRepository.findByDepartmentName("IT")).thenReturn(department);
    }

    @Test
    @DisplayName("Get data based on Valid Department")
    @Disabled
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName = "IT";
        Department found = departmentService.getDepartmentByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());

    }
}