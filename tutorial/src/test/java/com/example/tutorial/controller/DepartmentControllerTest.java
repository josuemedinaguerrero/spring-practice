package com.example.tutorial.controller;

import com.example.tutorial.entity.Department;
import com.example.tutorial.service.DepartmentService;
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
@WebMvcTest(DepartmentControllerTest.class)
class DepartmentControllerTest {

   @Autowired
   private MockMvc mockMvc;
   @MockBean
   private DepartmentService departmentService;

   private Department department;

   @BeforeEach
   void setUp() {
      department = Department.builder()
              .departmentName("SIS")
              .departmentCode("ENG-48")
              .departmentAddress("Colombia")
              .departmentId(1L)
              .build();
   }

   @Test
   void saveDepartment() throws Exception {
      Department inputDepartment = Department.builder()
              .departmentName("SIS")
              .departmentCode("ENG-48")
              .departmentAddress("Colombia")
              .build();

      Mockito.when(departmentService.saveDepartment(inputDepartment))
              .thenReturn(department);

//      mockMvc.perform(MockMvcRequestBuilders.post("/departments")
//              .contentType(MediaType.APPLICATION_JSON)
//              .content("{\n" +
//                      "    \"departmentId\": 1,\n" +
//                      "    \"departmentName\": \"AC\",\n" +
//                      "    \"departmentAddress\": \"ECUADOR\",\n" +
//                      "    \"departmentCode\": \"IT-01\"\n" +
//                      "  },"))
//              .andExpect(MockMvcResultMatchers.status().isOk());
   }

   @Test
   public void fetchDepartmentById() {
   }
}
