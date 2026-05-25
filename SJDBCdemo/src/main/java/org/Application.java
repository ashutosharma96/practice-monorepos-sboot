package org;

import java.util.List;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext context=	SpringApplication.run(Application.class, args);
        Student s= context.getBean(Student.class);
        s.setRollNo(4);
        s.setName("Sharko");
        s.setMarks(96);
        StudentService service=context.getBean(StudentService.class);
        service.addStudent(s);

        List<Student> students=service.getStudents();
        System.out.println(students);

    }

}
