package com.acss.dao;

import java.util.List;

import com.acss.model.Student;

public interface StudentDAO {

	public void save (Student student);
	
	public List<Student> list();
}
