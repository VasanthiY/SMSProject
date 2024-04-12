package com.vasanthi.SMS.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/*
 * @author Krishna Vasanthi Yakkala
 */
@Entity
public class Professor {

	@Id
	private int professorId;
	private String professorName;

	public int getProfessorId() {
		return professorId;
	}

	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	public String getProfessorName() {
		return professorName;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

	@Override
	public String toString() {
		return "Professor [professorId=" + professorId + ", professorName=" + professorName + "]";
	}

}
