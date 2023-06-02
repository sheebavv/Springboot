package com.sheeba.springboot.tutorial.repository;

import com.sheeba.springboot.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

    public Department findByDepartmentName(String departmentName);
}
