package com.acss.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acss.dao.StudentDAO;
import com.acss.model.Student;
import com.acss.service.IStudentService;

@Service
public class StudentService implements IStudentService {

	@Autowired
	private StudentDAO studentDao;
	
	@Override
	public List<Student> list() {
		return studentDao.list();
	}

	@Override
	public void save(Student student) {
		studentDao.save(student);
	}

	@Override
	public void update(Student student) {
		studentDao.update(student);
	}

	@Override
	public void delete(Student student) {
		studentDao.delete(student);
	}

}
