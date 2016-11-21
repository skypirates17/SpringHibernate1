package com.acss.service;

import java.util.List;

import com.acss.model.Student;

public interface IStudentService {
	List<Student> list();
	
	void save (Student student);
	
	void update (Student student);
	
	void delete (Student student);
}
