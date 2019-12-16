package com.thomas.banking.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.thomas.banking.util.AccountLevel;

@Entity
public class User {

	private Long id;
	private String firstName;
	private String lastName;
	private AccountLevel level;
	@OneToMany(mappedBy = "user")
	private HashSet<Account> accounts;

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

	public HashSet<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(HashSet<Account> accounts) {
		this.accounts = accounts;
	}

}
