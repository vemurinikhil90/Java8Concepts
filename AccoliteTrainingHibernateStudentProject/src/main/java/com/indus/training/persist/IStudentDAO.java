package com.indus.training.persist;

import com.indus.training.persist.entity.StudentDO;
import com.indus.training.persist.exception.StudentPersistenceException;


public interface IStudentDAO{
	public StudentDO getStudentDetailsById(int i)throws StudentPersistenceException;
	  
}
