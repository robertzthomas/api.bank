package com.thomas.banking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.ManyToOne;

import com.thomas.banking.util.AccountLevel;

@Entity
public class Account {

	private Long accountNumber;
	private String accountType;
	private AccountLevel level;
	private Double accountBalance;

	@JsonIgnore
	@ManyToOne
	public User user;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
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

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

}
