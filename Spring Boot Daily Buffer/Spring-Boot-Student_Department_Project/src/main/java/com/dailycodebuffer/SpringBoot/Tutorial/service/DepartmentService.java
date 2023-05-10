package com.dailycodebuffer.SpringBoot.Tutorial.service;

import com.dailycodebuffer.SpringBoot.Tutorial.entity.Department;
import com.dailycodebuffer.SpringBoot.Tutorial.error.DepartmentNotFoundException;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departureName);

    Department updateDepartmentByFields(Long departmentId, Map<String, Object> fields);
}
