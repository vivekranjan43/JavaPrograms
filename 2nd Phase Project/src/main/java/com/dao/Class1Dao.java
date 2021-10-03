package com.dao;

import java.util.List;
import com.dto.Class1;

public interface Class1Dao {
	
	public List<Class1> listAllClasses();
	public Class1 addClass(Class1 class1);
	public void updateClass1(Class1 class1);
	public void deleteClass1(int classId);
	public Class1 searchClass1ById(int id);

}
