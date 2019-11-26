package com.thomas.banking.repository;

import org.springframework.data.repository.CrudRepository;

import com.thomas.banking.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {
}