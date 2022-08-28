package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
   public List<Student> findByFirstName( String firstName );
   public List<Student> findByFirstNameContaining( String firstName );

   public List<Student> findByLastNameNotNull();
   public List<Student> findByGuardianName( String guardianName );
   @Query(
           value = "SELECT * FROM schooldb.tbl_student WHERE email_address = \"test1@test.com\"",
           nativeQuery = true
   )
   public Student getStudentByEmailAddressNative( String emailId );
}
