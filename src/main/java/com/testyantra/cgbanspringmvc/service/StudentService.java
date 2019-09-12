package com.testyantra.cgbanspringmvc.service;

import com.testyantra.cgbanspringmvc.beans.StudentInfo;
import com.testyantra.cgbanspringmvc.beans.StudentOtherInfo;

public interface StudentService {
	
	public boolean addStudent(StudentInfo info, StudentOtherInfo otherInfo);
	
	public StudentInfo auth(int id, String password);
	
	public boolean editStudent(StudentInfo info, StudentOtherInfo otherInfo);
	
	public boolean deleteStudent(StudentInfo info);
}
