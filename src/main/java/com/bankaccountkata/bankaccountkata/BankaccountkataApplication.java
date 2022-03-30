package com.bankaccountkata.bankaccountkata;

import com.bankaccountkata.bankaccountkata.service.TraitementBankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankaccountkataApplication implements CommandLineRunner {

	@Autowired
	TraitementBankAccountService traitementBankAccountService;

	public static void main(String[] args) {
		SpringApplication.run(BankaccountkataApplication.class, args);
	}

	//initialisation de la base de données
	@Override
	public void run(String... args) throws Exception {
		traitementBankAccountService.initClient();
		traitementBankAccountService.initAccount();
		traitementBankAccountService.initTransaction();
	}

}
