package com.thomas.banking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.thomas.banking.util.AccountLevel;

@Entity
public class Account {

	private int accountNumber;
	private String accountType;
	private AccountLevel level;

	@JsonIgnore
	private User user;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public AccountLevel getLevel() {
		return level;
	}

	public void setLevel(AccountLevel level) {
		this.level = level;
	}

}
