package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.Course;
import com.example.springdatajpa.entity.Student;
import com.example.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

   @Autowired
   private CourseRepository courseRepository;

   @Test
   public void printCourses() {
      List<Course> courses = courseRepository.findAll();
      System.out.println( courses );
   }

   @Test
   public void saveCourseWithTeacher() {
      Teacher teacher = Teacher.builder()
              .firstName("Teacher3")
              .lastName("ApellidoTeacher3")
              .build();
      Course course = Course.builder()
              .title("JavaScript")
              .credit(3)
              .teacher(teacher)
              .build();
      courseRepository.save( course );
   }

   @Test
   public void saveCourseWithStudentAndTeacher() {
      Teacher teacher = Teacher.builder()
              .firstName("Teacher4")
              .lastName("ApellidoTeacher4")
              .build();
      Student student = Student.builder()
              .firstName("Test4")
              .lastName("ApellidoTest4")
              .emailId("test4@test.com")
              .build();
      Course course = Course.builder()
              .title("AI")
              .credit(15)
              .teacher(teacher)
              .build();
      course.addStudents( student );
      courseRepository.save( course );
   }
}
