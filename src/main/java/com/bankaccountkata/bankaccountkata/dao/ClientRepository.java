package com.bankaccountkata.bankaccountkata.dao;

import com.bankaccountkata.bankaccountkata.entites.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
