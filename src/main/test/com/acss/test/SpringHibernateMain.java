package com.acss.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acss.model.Student;
import com.acss.service.IStudentService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:dispatcher-servlet.xml")
public class SpringHibernateMain {

	private final Logger logger = Logger.getLogger(SpringHibernateMain.class);
	
	@Autowired
	private IStudentService studentService;
	
	@After
	public void destroy() {
		studentService = null;
	}
	
	
	public void testList() {
		List<Student> list = studentService.list();
		
		for(Student std : list){
			logger.debug("Student List::" + std);
		}
	}
	
	
	public void testSave() {
		Student student = new Student();
		student.setName("MAMA"); 
		student.setAddress("PERU");
		student.setAge("18");
		
		studentService.save(student);
		
		this.testList();
	}
	
	@Test
	public void testUpdate() {
		Student student = new Student();
		student.setId(22);
		student.setName("HOHOHOHO"); 
		student.setAddress("HEHEHEHEH");
		student.setAge("55");
		
		studentService.update(student);
		
		this.testList();
	}
	
	public void testDelete() {
		Student student = new Student();
		student.setId(21);
		
		studentService.delete(student);
		
		this.testList();
	}
	
	/*
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
	*/

}
