package com.techtest.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.techtest.domain.models.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
