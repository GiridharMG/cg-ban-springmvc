package com.testyantra.cgbanspringmvc.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testyantra.cgbanspringmvc.beans.StudentInfo;
import com.testyantra.cgbanspringmvc.beans.StudentOtherInfo;
import com.testyantra.cgbanspringmvc.dao.StudentDAO;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO dao;
	
	@Override
	public boolean addStudent(StudentInfo info, StudentOtherInfo otherInfo) {
		otherInfo.setInfo(info);
		info.setOtherInfo(otherInfo);
		return dao.addStudent(info, otherInfo);
	}

	@Override
	public StudentInfo auth(int id, String password) {
		
		StudentInfo info = dao.auth(id, password);
		if(info.getOtherInfo().getPassword().equals(password)) {
			return info;
		}
		return null;
	}

	@Override
	public boolean editStudent(StudentInfo info, StudentOtherInfo otherInfo) {
		info.setOtherInfo(otherInfo);
		otherInfo.setInfo(info);
		dao.editStudent(info, otherInfo);
		return true;
	}

	@Override
	public boolean deleteStudent(StudentInfo info) {
		return dao.deleteStudent(info);
	}

}
