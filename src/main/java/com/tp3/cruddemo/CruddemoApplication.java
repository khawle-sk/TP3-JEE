package com.tp3.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import com.tp3.cruddemo.entity.Student;
import com.tp3.cruddemo.dao.*;
import java.util.List;

// @SpringBootApplication
// public class CruddemoApplication {
//   public static void main(String[] args) {
    
//   SpringApplication.run(CruddemoApplication.class, args);

//  }
// }

@SpringBootApplication
public class CruddemoApplication {
    public static void main(String[] args) {
       SpringApplication.run(CruddemoApplication.class, args);
     }

    // @Bean 
    // public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
    //    return runner -> {
        //    Student myStudent = studentDAO.findById(1);
        //    System.out.println("Found the student: " + myStudent);

            // List<Student> theStudents = studentDAO.findAll();
            // for (Student s : theStudents) {
            //     System.out.println(s);
            // }


            // List<Student> theStudents = studentDAO.findByLastName("Doe");
            // theStudents.forEach(System.out::println);


            // int studentId = 1;
            // Student myStudent = studentDAO.findById(studentId);
            // myStudent.setFirstName("John");
            // studentDAO.update(myStudent);
            // System.out.println("Updated student: " + studentDAO.findById(studentId));

            // studentDAO.delete(1);
            // System.out.println("After delete, findById(1) = " + studentDAO.findById(1));

    //         int n = studentDAO.deleteAll();
    //         System.out.println("Deleted row count: " + n);
    //     };
    // }

      @Bean
      public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

          return args -> {

              String action = (args.length > 0) ? args[0] : "read";

                  switch (action) {

                     case "create" -> createStudent(studentDAO);

                     case "read" -> readStudents(studentDAO);

                     case "update" -> updateStudent(studentDAO);

                      case "delete" -> deleteStudent(studentDAO);

               default -> System.out.println("Action inconnue: " + action);
            }
        };
    }


    // private void createStudent(StudentDAO studentDAO) {
    //     Student tempStudent = new Student("Paul", "Doe", "paul@test.com");
    //     studentDAO.save(tempStudent);
    //     System.out.println("Saved student. Generated id: " + tempStudent.getId());
    // }

    private void readStudents(StudentDAO studentDAO) {

    List<Student> students = studentDAO.findAll();

    for (Student student : students) {
        System.out.println(student);
    }
}


    
private void createStudent(StudentDAO studentDAO) {

    Student student = new Student(
            "Fatima",
            "Ahmed",
            "fatima@gmail.com"
    );

    studentDAO.save(student);

    System.out.println("Student created: " + student);
}


private void updateStudent(StudentDAO studentDAO) {

    int studentId = 1;

    Student student = studentDAO.findById(studentId);

    if (student != null) {

        student.setFirstName("Fatima Updated");

        studentDAO.update(student);

        System.out.println("Student updated: " + student);

    } else {
        System.out.println("Student not found with id: " + studentId);
    }
}


private void deleteStudent(StudentDAO studentDAO) {

    int studentId = 1;

    Student student = studentDAO.findById(studentId);

    if (student != null) {

        studentDAO.delete(studentId);

        System.out.println("Student deleted with id: " + studentId);

    } else {
        System.out.println("Student not found with id: " + studentId);
    }
}













}