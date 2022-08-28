package com.example.springdatajpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class Course {

   @Id
   @SequenceGenerator(
           name = "course_sequence",
           sequenceName = "course_sequence",
           allocationSize = 1
   )
   @GeneratedValue(
           strategy = GenerationType.SEQUENCE,
           generator = "course_sequence"
   )
   private Long courseId;

   private String title;
   private Integer credit;

//
//   One to One
   @OneToOne( mappedBy = "course" )
   private CourseMaterial courseMaterial;

//
//   Many to One
   @ManyToOne(
           cascade = CascadeType.ALL
   )
   @JoinColumn(
           name = "teacher_id",
           referencedColumnName = "teacherId"
   )
   private Teacher teacher;

//
//   Many to Many
   @ManyToMany(
           cascade = CascadeType.ALL
   )
   @JoinTable(
           name = "student_course_map",
           joinColumns = @JoinColumn(
                   name = "course_id",
                   referencedColumnName = "courseId"
           ),
           inverseJoinColumns = @JoinColumn(
                   name = "student_id",
                   referencedColumnName = "studentId"
           )
   )
   private List<Student> students;

   public void addStudents( Student student ) {
      if ( students == null ) students = new ArrayList<>();
      students.add( student );
   }
}