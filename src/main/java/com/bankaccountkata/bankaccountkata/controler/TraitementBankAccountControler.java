package com.bankaccountkata.bankaccountkata.controler;

import com.bankaccountkata.bankaccountkata.entites.Account;
import com.bankaccountkata.bankaccountkata.entites.AccountDto;
import com.bankaccountkata.bankaccountkata.entites.Operation;
import com.bankaccountkata.bankaccountkata.service.TraitementBankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TraitementBankAccountControler {

    @Autowired
    TraitementBankAccountService traitementBankAccountService;

    @PostMapping("/depositAccount/{credit}")
    public Account depositAccount(@PathVariable("credit")double credit, @RequestBody AccountDto accountDto){
        return traitementBankAccountService.depositAccount(credit,accountDto);
    }

    @PostMapping("/withdrawalAccount/{debit}")
    public Account withdrawalAccount(@PathVariable("debit")double debit, @RequestBody AccountDto accountDto){
        return traitementBankAccountService.withdrawalAccount(debit,accountDto);
    }

    @GetMapping("/getHistoryTransaction/{id}")
    public List<Operation> getHistoryTransaction(@PathVariable("id")Long id){
        return traitementBankAccountService.seeHistory(id);
    }
}
