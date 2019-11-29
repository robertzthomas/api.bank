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

	public User getUserById(Long id) throws Exception {
		try {
			return repo.findOne(id);
		} catch (Exception e) {
			logger.error("Exception occured while trying to get user " + id, e);
			throw e;
		}
	}

	public Iterable<User> getUsers() {
		return repo.findAll();
	}

	public User createUser(User user) {
		return repo.save(user);
	}

	public User updateUser(User user, Long id) throws Exception {
		try {
			User oldUser = repo.findOne(id);
			oldUser.setFirstName(user.getFirstName());
			oldUser.setLastName(user.getLastName());
			oldUser.setLevel(user.getLevel());
			return repo.save(oldUser);
		} catch (Exception e) {
			logger.error("Exception occured while trying to update user: " + id, e);
			throw new Exception("Unable to update user");
		}
	}

	public void deleteUser(Long id) throws Exception {
		try {
			repo.delete(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to delete user: " + id, e);
			throw new Exception("Unable to delete user");
		}
	}
}
