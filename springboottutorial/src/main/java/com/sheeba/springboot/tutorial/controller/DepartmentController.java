package com.sheeba.springboot.tutorial.controller;

import com.sheeba.springboot.tutorial.entity.Department;
import com.sheeba.springboot.tutorial.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController
{
    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping("/department")
    public Department saveDepartment(@Valid  @RequestBody Department department){
        LOGGER.info("Inside save method in DepartmentController");
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/departments")
    public List<Department> getDepartment(){
        return departmentService.getDepartments();
    }

    @GetMapping("/departmentById/{id}")
    public Department getDepartmentByID(@PathVariable("id")Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/deleteDepartments")
    public void deleteDepartments(){
         departmentService.deleteDepartments();
    }

    @PutMapping("/updateDepartmentById/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long id, @RequestBody Department department){
            return departmentService.updateDepartmnetById(id,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.getDepartmentByName(departmentName);

    }
}
