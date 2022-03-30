package com.bankaccountkata.bankaccountkata.service;

import com.bankaccountkata.bankaccountkata.dao.AccountRepository;
import com.bankaccountkata.bankaccountkata.dao.ClientRepository;
import com.bankaccountkata.bankaccountkata.dao.OperationRepository;
import com.bankaccountkata.bankaccountkata.entites.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@Transactional
public class TraitementBankAccountServiceImp implements TraitementBankAccountService
{
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    OperationRepository operationRepository;


    @Override
    public Account depositAccount(double credit, AccountDto accountDto) {
        Account a = accountRepository.findById(accountDto.getId()).get();
        a.setSolde(a.getSolde()+credit);
        Operation operation = new Operation();
        operation.setMontant(credit);
        operation.setTypeTransaction(TypeTransaction.CREDIT.toString());
        operation.setDateTransaction(LocalDateTime.now());
        operation.setSolde(a.getSolde());
        operation.setAccount(a);
        a.getOperations().add(operation);
        accountRepository.save(a);
        return a;
    }

    @Override
    public Account withdrawalAccount(double debit, AccountDto accountDto) {
        Account a = accountRepository.findById(accountDto.getId()).get();
        a.setSolde(a.getSolde()-debit);
        Operation operation = new Operation();
        operation.setMontant(debit);
        operation.setTypeTransaction(TypeTransaction.DEBIT.toString());
        operation.setDateTransaction(LocalDateTime.now());
        operation.setSolde(a.getSolde());
        operation.setAccount(a);
        a.getOperations().add(operation);
        accountRepository.save(a);
        return a;
    }

    @Override
    public List<Operation> seeHistory(Long id) {
        return (List)accountRepository.findById(id).get().getOperations();
    }

    @Override
    public void initClient() {
        Stream.of("Yassin","Thomas","Laurent","Gad").forEach(nameClient->{
            Client client = new Client();
            client.setPrenom(nameClient);
            client.setNom("Nom_"+nameClient);
            client.setAdress("Paris");
            clientRepository.save(client);
        });
    }

    @Override
    public void initAccount() {
        clientRepository.findAll().forEach(c->{
            Stream.of(0).forEach(s->{
                Account account = new Account();
                account.setClient(c);
                account.setSolde(s);
                accountRepository.save(account);
            });
        });
    }

    @Override
    public void initTransaction() {
        accountRepository.findAll().forEach(a->{
            Stream.of("credit").forEach(t->{
                Operation operation = new Operation();
                operation.setAccount(a);
                operation.setTypeTransaction(t);
                operation.setMontant(0);
                operation.setSolde(0);
                operation.setDateTransaction(LocalDateTime.now());
                operationRepository.save(operation);
            });
        });

    }
}
