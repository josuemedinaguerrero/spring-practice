package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.Guardian;
import com.example.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

   @Autowired
   private StudentRepository studentRepository;

   @Test
   public void saveStudent() {
      Student student =Student.builder()
              .emailId("test2@test.com")
              .firstName("Test2")
              .lastName("ApellidoTest2")
//              .guardianName("Guardian2")
//              .guardianEmail("guardian2@test.com")
//              .guardianMobile("999")
              .build();

      studentRepository.save( student );
   }

   @Test
   public void saveStudentWithGuardian() {
      Guardian guardian = Guardian.builder()
              .name("Guardian3")
              .email("guardian3@test.com")
              .mobile("999")
              .build();
      Student student = Student.builder()
              .firstName("Test3")
              .lastName("ApellidoTest3")
              .emailId("test3@test.com")
              .guardian(guardian)
              .build();
      studentRepository.save( student );
   }

   @Test
   public void printALlStudents() {
      List<Student> studentList = studentRepository.findAll();
      System.out.println(studentList);
   }

   @Test
   public void printStudentByFirstName() {
      List<Student> students = studentRepository.findByFirstName("Test1");
      System.out.println( students );
   }

   @Test
   public void printStudentByFirstNameContaining() {
      List<Student> students = studentRepository.findByFirstNameContaining("1");
      System.out.println(students);
   }

   @Test
   public void printStudentBasedOnGuardianName() {
      List<Student> students = studentRepository.findByGuardianName("Guardian2");
      System.out.println( students );
   }

   @Test
   public void printGetStudentFirstNameByEmailAddress() {
      Student firstName = studentRepository.getStudentByEmailAddressNative("test1@test.com");
      System.out.println( firstName );
   }

}
