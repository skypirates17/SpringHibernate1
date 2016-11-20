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
		//Session session = 
				this.getSessionFactory().save(student); //this.sessionFactory.openSession();
		//Transaction tx = session.beginTransaction();
		//session.persist(student);
		//tx.commit();
		//session.close();
	}

	@Override
	public List<Student> list() {
		/*
		Session session = sessionFactory.getCurrentSession(); //this.sessionFactory.openSession();
		List<Student> personList = session.createQuery("from student_info").list();
		session.close();
		return personList;
		*/

		Query query = this.getSessionFactory().createQuery("from Student");
		//query.setParameter("iduser", dto.getUser().getId());
		
		List<Student> personList = query.list();

		return personList;
	}

}
