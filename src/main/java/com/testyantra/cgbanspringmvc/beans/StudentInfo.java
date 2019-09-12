package com.testyantra.cgbanspringmvc.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_info")
public class StudentInfo implements Serializable {
	@Id
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private int age;
	@Column
	private Date dob;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "info")
	private StudentOtherInfo otherInfo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public StudentOtherInfo getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(StudentOtherInfo otherInfo) {
		this.otherInfo = otherInfo;
	}
}
