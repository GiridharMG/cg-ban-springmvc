package com.testyantra.cgbanspringmvc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.testyantra.cgbanspringmvc.beans.StudentInfo;
import com.testyantra.cgbanspringmvc.beans.StudentOtherInfo;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public boolean addStudent(StudentInfo info, StudentOtherInfo otherInfo) {
		EntityManager em = emf.createEntityManager();
		StudentInfo bean = em.find(StudentInfo.class, info.getId());
		if (bean == null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(info);
			transaction.commit();
			em.close();
			return true;
		}
		return false;
	}

	@Override
	public StudentInfo auth(int id, String password) {
		EntityManager em = emf.createEntityManager();
		StudentInfo info = em.find(StudentInfo.class, id);
		em.close();
		return info;
	}

	@Override
	public boolean editStudent(StudentInfo info, StudentOtherInfo otherInfo) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		StudentInfo bean = em.find(StudentInfo.class, info.getId());
		if (bean != null) {
			bean.setName(info.getName());
			bean.setAge(info.getAge());
			bean.setDob(info.getDob());
			bean.getOtherInfo().setEmail(otherInfo.getEmail());
			bean.getOtherInfo().setPassword(otherInfo.getPassword());
			transaction.commit();
			em.close();
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteStudent(StudentInfo info) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.remove(em.find(StudentInfo.class,info.getId()));
		transaction.commit();
		em.close();
		return true;
	}

}
