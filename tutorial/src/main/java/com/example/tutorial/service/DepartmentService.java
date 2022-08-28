package com.example.tutorial.service;

import com.example.tutorial.entity.Department;
import com.example.tutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
   public Department saveDepartment( Department department );
   public List<Department> fetchDepartmentList();
   public Department fetchDepartmentById( Long department ) throws DepartmentNotFoundException;
   public void deleteDepartmentById( Long departmentId );
   public Department updateDepartment( Long departmentId, Department department );
   public List<Department> fetchDepartmentByName( String departmentName );
}
