package com.thomas.banking.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.thomas.banking.util.AccountLevel;

public class User {

	private Long id;
	private String firstName;
	private String lastName;
	private AccountLevel level;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public AccountLevel getLevel() {
		return level;
	}

	public void setLevel(AccountLevel level) {
		this.level = level;
	}

}
