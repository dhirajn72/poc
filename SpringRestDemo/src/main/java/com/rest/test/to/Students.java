package com.rest.test.to;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "students")
public class Students {
	List<StudentTo> studentTos = new ArrayList<StudentTo>();

	@XmlElement(name = "student")
	public List<StudentTo> getStudentTos() {
		return studentTos;
	}

	public void setStudentTos(List<StudentTo> studentTos) {
		this.studentTos = studentTos;
	}

}
