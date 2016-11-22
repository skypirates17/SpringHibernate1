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

/**
 * JUNIT Testing for Hibernate Query Language
 * 
 * @author Johnrey Angolluan
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:dispatcher-servlet.xml")
public class TestSpringHibernateHQL {

	private final Logger logger = Logger.getLogger(TestSpringHibernateHQL.class);
	
	@Autowired
	private IStudentService studentService;
	
	@After
	public void destroy() {
		studentService = null;
	}
	
	
	public void testListHQL() {
		List<Student> list = studentService.listAllHQL();
		
		for(Student std : list){
			logger.debug("Student List::" + std);
		}
	}
	
	@Test
	public void testGetByIdHQL() {
		Student student = new Student();
		student.setId(1);
		
		Student studInfo = studentService.getByIdHQL(student);
		logger.debug("STUDENT ==> " + studInfo);
	}
	
	public void testSaveHQL() {
		Student student = new Student();
		student.setName("MAMA"); 
		student.setAddress("PERU");
		student.setAge("18");
		
		studentService.saveHQL(student);
		
		this.testListHQL();
	}
	
	
	public void testUpdateHQL() {
		Student student = new Student();
		student.setId(22);
		student.setName("HOHOHOHO"); 
		student.setAddress("HEHEHEHEH");
		student.setAge("55");
		
		studentService.updateHQL(student);
		
		this.testListHQL();
	}
	
	public void testDeleteHQL() {
		Student student = new Student();
		student.setId(21);
		
		studentService.deleteHQL(student);
		
		this.testListHQL();
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
