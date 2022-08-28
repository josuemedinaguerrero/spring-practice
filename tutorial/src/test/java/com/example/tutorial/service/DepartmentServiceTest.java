package com.example.tutorial.service;

import com.example.tutorial.entity.Department;
import com.example.tutorial.error.DepartmentNotFoundException;
import com.example.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

   @Autowired
   private DepartmentService departmentService;
   @MockBean
   private DepartmentRepository departmentRepository;

   @BeforeEach
   void setUp() {
      Department department =
              Department.builder()
                      .departmentName("IT")
                      .departmentAddress("Daule")
                      .departmentCode("IT-05")
                      .departmentId(1L)
                      .build();
      Mockito.when(departmentRepository.findById(1L))
              .thenReturn(Optional.ofNullable(department));
   }

   @Test
   @DisplayName("Get Data by Id")
   public void whenValidDepartmentName_thenDepartmentShouldFound() throws DepartmentNotFoundException {
      Department department =
              Department.builder()
                      .departmentName("IT")
                      .departmentAddress("Daule")
                      .departmentCode("IT-05")
                      .departmentId(1L)
                      .build();
      Department found = departmentService.fetchDepartmentById( 1L );
      assertEquals( department, found );
   }

}
