package com.todo.rest.webservices.restfulwebservices.versioning;

public class Name {
	private String firstNasme;
	private String lastName;
	  
	public Name() {
	}

	
	public Name(String firstNasme, String lastName) {
		super();
		this.firstNasme = firstNasme;
		this.lastName = lastName;
	}
  
	public String getFirstNasme() {
		return firstNasme;
	}

	public void setFirstNasme(String firstNasme) {
		this.firstNasme = firstNasme;
	}

	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
