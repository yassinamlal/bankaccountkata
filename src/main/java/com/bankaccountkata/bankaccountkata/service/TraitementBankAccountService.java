package com.bankaccountkata.bankaccountkata.service;

import com.bankaccountkata.bankaccountkata.entites.*;

import java.util.List;

public interface TraitementBankAccountService {

    public Account depositAccount(double credit, AccountDto accountDto);
    public Account withdrawalAccount(double credit, AccountDto accountDto);
    public List<Operation> seeHistory(Long id);
    public void initClient();
    public void initAccount();
    public void initTransaction();
}
