package com.rolex.crud;

import com.rolex.crud.dao.StudentDAO;
import com.rolex.crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {

		int rowDeleted =  studentDAO.deleteAll();

		System.out.println("Row Deleted: " + rowDeleted);

	}

	private void deleteStudent(StudentDAO studentDAO) {
		int id = 1;
		studentDAO.delete(id);
		System.out.println("Successfully deleted student");
	}

	private void updateStudent(StudentDAO studentDAO) {
		int id = 1;
		Student student = studentDAO.findById(id);
		student.setFirstName("Scooby");
		studentDAO.update(student);
		System.out.println("Updated student: " + student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		List<Student> students = studentDAO.findByLastName("john");

		for (Student temp : students){
			System.out.println(temp);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();

		for (Student temp : students){
			System.out.println(temp);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		Student student = studentDAO.findById(1);

		System.out.println("Found the student: " + student);
	}

	private void createStudent(StudentDAO studentDAO) {

		System.out.println("Creating new student");

		Student student = new Student("paul", "john", "paul@gmail.com");

		studentDAO.save(student);

		System.out.println("Saved" + student.getId());

	}
}
