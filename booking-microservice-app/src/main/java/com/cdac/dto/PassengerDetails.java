package com.cdac.dto;

public class PassengerDetails {

	private String name;
	private Gender gender;
	
	public static enum Gender {
		MALE, FEMALE, OTHER;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

}
