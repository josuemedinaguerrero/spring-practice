package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.Course;
import com.example.springdatajpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
   @Autowired
   private CourseMaterialRepository courseMaterialRepository;

   @Test
   public void saveCourseMaterial() {
      Course course = Course.builder()
              .title("MA1")
              .credit(45)
              .build();
      CourseMaterial courseMaterial = CourseMaterial.builder()
              .url("www.google.com")
              .course(course)
              .build();
      courseMaterialRepository.save( courseMaterial );
   }

}
