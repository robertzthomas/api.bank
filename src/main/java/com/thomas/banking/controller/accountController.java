package com.thomas.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.util.MultiValueMap;

import com.thomas.banking.entity.Account;
//import com.thomas.banking.entity.User;
import com.thomas.banking.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountService service;
	
	@RequestMapping(value="{number}", method = RequestMethod.GET)
	public ResponseEntity<Object> getAccount(@PathVariable Long accountNumber){
		try {
			return new ResponseEntity<Object>(service.getAccount(accountNumber), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getAccounts(){
		return new ResponseEntity<Object>(service.getAccounts(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createAccount(@RequestBody Account account){
		return new ResponseEntity<Object>(service.createAccount(account), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{number}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateAccount(@RequestBody Account account, @PathVariable Long accountNumber){
		try {
			return new ResponseEntity<Object>(service.updateAccount(account, accountNumber), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/{number}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteAccount(@PathVariable Long accountNumber) {
		try {
			service.deleteAccount(accountNumber);
			return new ResponseEntity<Object>("Successfully deleted Account: " + accountNumber, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
