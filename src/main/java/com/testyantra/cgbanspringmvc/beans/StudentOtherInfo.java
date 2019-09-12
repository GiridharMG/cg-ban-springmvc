package com.testyantra.cgbanspringmvc.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_otherinfo")
public class StudentOtherInfo implements Serializable {
	@Id
	@OneToOne
	@JoinColumn(name = "id")
	private StudentInfo info;
	@Column(unique = true)
	private String email;
	@Column
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public StudentInfo getInfo() {
		return info;
	}

	public void setInfo(StudentInfo info) {
		this.info = info;
	}

}
