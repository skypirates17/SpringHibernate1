package com.acss.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acss.dao.StudentDAO;
import com.acss.model.Student;


public class SpringHibernateMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dispatcher-servlet.xml");
		
		StudentDAO studentDAO = context.getBean(StudentDAO.class);
		
		Student student = new Student();
		student.setName("67777"); 
		student.setAddress("545345");
		student.setAge("8");
		
		studentDAO.save(student);
		
		System.out.println("Student::"+student);
		
		List<Student> list = studentDAO.list();
		
		for(Student std : list){
			System.out.println("Student List::"+std);
		}
		//close resources
		context.close();

	}

}
