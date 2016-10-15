package com.indus.training.persist.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.indus.training.persist.IStudentDAO;
import com.indus.training.persist.entity.StudentDO;
import com.indus.training.persist.exception.StudentPersistenceException;
import com.indus.training.persist.util.HibernateUtil;


//@Repository("stdDAOObj")
public class StudentDAOImpl implements IStudentDAO {

	public StudentDO getStudentDetailsById(int id) throws StudentPersistenceException {
		StudentDO empEntity = null;

		Session orclSessionObj = HibernateUtil.getSessionFactory().openSession();

		Transaction orclEmpTrnsObj = orclSessionObj.getTransaction();

		try {
			orclEmpTrnsObj.begin();

			empEntity = (StudentDO) orclSessionObj.get(StudentDO.class, id);

			orclEmpTrnsObj.commit();

		} catch (Exception ex) {
			orclEmpTrnsObj.rollback();
		} finally {
			orclSessionObj.close();
		}

		return empEntity;
	}
}