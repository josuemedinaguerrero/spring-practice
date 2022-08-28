package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.Course;
import com.example.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

   @Autowired
   private TeacherRepository teacherRepository;

//   @Test
//   public void saveTeacher() {
//      Course coursePy = Course.builder()
//              .title("Python")
//              .credit(4)
//              .build();
//      Course courseJava = Course.builder()
//              .title("Java")
//              .credit(5)
//              .build();
//      Teacher teacher = Teacher.builder()
//              .firstName("Teacher2")
//              .lastName("ApellidoTeacher2")
//              .courses(List.of(coursePy, courseJava))
//              .build();
//      teacherRepository.save( teacher );
//   }
}
