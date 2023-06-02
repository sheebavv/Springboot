package com.sheeba.springboot.tutorial.service;

import com.sheeba.springboot.tutorial.entity.Department;
import com.sheeba.springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public void deleteDepartments() {
        departmentRepository.deleteAll();
    }

    @Override
    public Department updateDepartmnetById(Long id, Department department) {
        Department deptDB = departmentRepository.findById(id).get();
        if(department != null && department.getDepartmentName() != ""){
            deptDB.setDepartmentName(department.getDepartmentName());
        }
        if(department != null && department.getDepartmentAddress() != ""){
            deptDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(department != null && department.getDepartmentCode() != ""){
            deptDB.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(deptDB);
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }


}
