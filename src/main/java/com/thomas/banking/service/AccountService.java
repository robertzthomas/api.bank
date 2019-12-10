package com.thomas.banking.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thomas.banking.entity.Account;
import com.thomas.banking.repository.AccountRepository;

@Service
public class AccountService {

	private final static Logger logger = LogManager.getLogger(AccountService.class);

	@Autowired
	private AccountRepository repo;

	public Account getAccount(Long accountNumber) throws Exception {
		try {
			return repo.findOne(accountNumber);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to get account: " + accountNumber, e);
			throw e;
		}
	}

	public Iterable<Account> getAccounts() {
		return repo.findAll();
	}

	public Account createAccount(Account account) {
		return repo.save(account);
	}

	public Account updateAccount(Account account, Long accountNumber) throws Exception {
		try {
			Account oldAccount = repo.findOne(accountNumber);
			oldAccount.setAccountType(account.getAccountType());
			oldAccount.setLevel(account.getLevel());
			return repo.save(oldAccount);
		} catch (Exception e) {
			logger.error("An exception occurred while trying to update account: " + accountNumber, e);
			throw new Exception("Unable to update account");
		}
	}

	public void deleteAccount(Long accountNumber) throws Exception {
		try {
			repo.delete(accountNumber);
		} catch (Exception e) {
			logger.error("An exception occurred while trying to delete account: " + accountNumber, e);
			throw new Exception("Unable to delete account");
		}
	}
}
