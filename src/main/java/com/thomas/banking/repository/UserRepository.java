package com.thomas.banking.repository;

import org.springframework.data.repository.CrudRepository;

import com.thomas.banking.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
}