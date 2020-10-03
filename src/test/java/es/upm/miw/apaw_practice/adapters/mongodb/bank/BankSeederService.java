package es.upm.miw.apaw_practice.adapters.mongodb.bank;


import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.*;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.*;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


@Service
public class BankSeederService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private MortgageRepository mortgageRepository;
    @Autowired
    private SharedAccountsRepository sharedAccountsRepository;
    @Autowired
    private ShareholderRepository shareholderRepository;


    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Bank Initial Load -----------");
        CustomerEntity[] customers = {
                new CustomerEntity("Ulises", "511511511L", "666777888", "ulises@email.com"),
                new CustomerEntity("Manuel", "511511777L", "666777999", "manuel@email.com"),
                new CustomerEntity("Jorge", "511511444M", "666777666", "mayoralcillo@email.com"),
                new CustomerEntity("Anabel", "511333511A", "666333888", "anabelen@email.com"),
                new CustomerEntity("Emma", "666511511J", "666777333", "emmatega@email.com"),
        };
        this.customerRepository.saveAll(Arrays.asList(customers));

        AccountEntity[] accounts = {
                new AccountEntity(new BigDecimal("68.54"), customers[0], "ES66 987651234"),
                new AccountEntity(new BigDecimal("4565.23"), customers[1], "ES66 123459876"),
                new AccountEntity(new BigDecimal("100.00"), customers[2], "ES66 365478912"),
                new AccountEntity(new BigDecimal("7000.50"), customers[3], "ES66 865973214")
        };
        this.accountRepository.saveAll(Arrays.asList(accounts));

        MortgageEntity[] mortgages = {
                new MortgageEntity(new BigDecimal("5000.00"), new BigDecimal("200.00"), customers[0]),
                new MortgageEntity(new BigDecimal("60000.00"), new BigDecimal("50300.00"), customers[4]),
                new MortgageEntity(new BigDecimal("1000.00"), BigDecimal.ZERO, customers[2]),
                new MortgageEntity(new BigDecimal("2000.00"), BigDecimal.ZERO, customers[3])
        };
        this.mortgageRepository.saveAll(Arrays.asList(mortgages));

        SharedAccountEntity[] sharedAccounts = {
                new SharedAccountEntity(new BigDecimal("4000.00"), "Family", "ES66 123123123",
                        List.of(customers[0], customers[1])),
                new SharedAccountEntity(new BigDecimal("20000.00"), "Enterprise", "ES66 321321321",
                        List.of(customers[0], customers[2], customers[4])),
                new SharedAccountEntity(new BigDecimal("100"), "Family", "ES66 256652256",
                        List.of(customers[1], customers[3]))
        };
        this.sharedAccountsRepository.saveAll(Arrays.asList(sharedAccounts));

        ShareholderEntity[] shareholders = {
                new ShareholderEntity(new BigDecimal("20.25"), new BigDecimal("1.22"),
                        List.of(customers[0], customers[1], customers[4])),
                new ShareholderEntity(new BigDecimal("79.75"), new BigDecimal("2.33"),
                        List.of(customers[2], customers[3]))
        };
        this.shareholderRepository.saveAll(Arrays.asList(shareholders));

    }

    public void deleteAll() {
        this.shareholderRepository.deleteAll();
        this.sharedAccountsRepository.deleteAll();
        this.mortgageRepository.deleteAll();
        this.accountRepository.deleteAll();
        this.customerRepository.deleteAll();
    }
}
