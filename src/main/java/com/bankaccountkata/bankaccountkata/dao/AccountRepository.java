package com.bankaccountkata.bankaccountkata.dao;

import com.bankaccountkata.bankaccountkata.entites.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
