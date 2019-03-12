package com.cg.beans;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Person {
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@NotNull
	int id;
	
	@NotNull
	@Size(min=3, max=50)
	@Pattern(regexp="[a-zA-Z\\s]+", message="name is Invalid")
	String name;
	
	@NotNull
	LocalDate time;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(int id, String name, LocalDate time) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
	}

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

	public LocalDate getTime() {
		return time;
	}

	public void setTime(LocalDate time) {
		this.time = time;
	}
}
