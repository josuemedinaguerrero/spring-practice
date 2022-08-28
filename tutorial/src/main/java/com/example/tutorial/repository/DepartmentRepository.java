package com.example.tutorial.repository;

import com.example.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
   public List<Department> findByDepartmentNameIgnoreCase( String departmentName );
}
