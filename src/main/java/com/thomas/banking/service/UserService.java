package com.thomas.banking.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thomas.banking.entity.User;
import com.thomas.banking.repository.UserRepository;

@Service
public class UserService {
	
	private static final Logger logger = LogManager.getLogger(UserService.class);

	@Autowired
	private UserRepository repo;
	
	public User getUserById(Long id) throws Exception{
		try {
			return repo.findOne(id);
		} catch (Exception e) {
			logger.error("Exception occured while trying to get user " + id, e);
			throw e;
		}
	}
	public Iterable<User> getUsers(){
		return repo.findAll();
	}
}
