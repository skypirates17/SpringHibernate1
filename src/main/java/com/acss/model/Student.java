package com.acss.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_info")
public class Student {

	@Id
	@Column(name="student_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@Column(name="student_name")
	private String name;

	@Column(name="student_age")
	private String age;

	@Column(name="student_address")
	private String address;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		
		sb.append("id=" + this.id);
		sb.append(", name=" + this.name);
		sb.append(", age" + this.age);
		sb.append(", address=" + this.address);
		
		return sb.toString();
	}

}
