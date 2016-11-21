package com.acss.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.acss.dao.StudentDAO;
import com.acss.model.Student;

@Repository
@Transactional
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	

	 /**
     * provides session factory that do not need to close after querying
     * @return Session for crud operations
     */
	public Session getSessionFactory() {
        return sessionFactory.getCurrentSession();
    }
	
	@Override
	public void save(Student student) {
		this.getSessionFactory().save(student); 
	}

	@Override
	public List<Student> list() {
		Query query = this.getSessionFactory().createQuery("from Student");
		List<Student> personList = query.list();

		return personList;
	}

	@Override
	public void update(Student student) {
		this.getSessionFactory().update(student);
		
	}

	@Override
	public void delete(Student student) {
		this.getSessionFactory().delete(student);
	}

}
