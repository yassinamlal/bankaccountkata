package com.bankaccountkata.bankaccountkata.dao;

import com.bankaccountkata.bankaccountkata.entites.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation,Long> {
}
