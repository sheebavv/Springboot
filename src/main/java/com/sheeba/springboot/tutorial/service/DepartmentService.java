package com.sheeba.springboot.tutorial.service;

import com.sheeba.springboot.tutorial.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentService
{
   public Department saveDepartment(Department department);

   List<Department> getDepartments();

   Department getDepartmentById(Long departmentId);

   void deleteDepartments();

   Department updateDepartmnetById(Long id, Department department);

   Department getDepartmentByName(String departmentName);
}
