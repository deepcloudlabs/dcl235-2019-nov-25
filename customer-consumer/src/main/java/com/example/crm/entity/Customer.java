package com.example.crm.entity;

public class Customer {
	private Identity identity;
	private FullName fullName;
	private String email;
	private Integer birthYear;
	private String photo;

	public Customer() {
	}

	public Customer(Identity identity, FullName fullName, String email, Integer birthYear) {
		this.identity = identity;
		this.fullName = fullName;
		this.email = email;
		this.birthYear = birthYear;
	}

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	public FullName getFullName() {
		return fullName;
	}

	public void setFullName(FullName fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(Integer birthYear) {
		this.birthYear = birthYear;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Customer [identity=" + identity + ", fullName=" + fullName + ", email=" + email + ", birthYear="
				+ birthYear + "]";
	}

}
