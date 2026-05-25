package com.example.springJPA;

import com.example.springJPA.model.Student;
import com.example.springJPA.repo.StudentRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(SpringJpaApplication.class, args);
		StudentRepo repo= context.getBean(StudentRepo.class);

		Student s1= context.getBean(Student.class);
		Student s2= context.getBean(Student.class);
		Student s3= context.getBean(Student.class);


		s1.setRollNo(101);
		s1.setName("Ashu");
		s1.setMarks(75);


		s2.setRollNo(102);
		s2.setName("Kiran");
		s2.setMarks(80);


		s3.setRollNo(103);
		s3.setName("Harsh");
		s3.setMarks(70);

		System.out.println(repo.findByName("Ashu"));

//		repo.save(s1);
//		repo.save(s2);
//		repo.save(s3);
	}

}
