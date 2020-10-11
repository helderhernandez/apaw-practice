package es.upm.miw.apaw_practice.adapters.mongodb.bank;


import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.*;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.*;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
    private SharedAccountRepository sharedAccountRepository;
    @Autowired
    private ShareholderRepository shareholderRepository;


    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Bank Initial Load -----------");
        CustomerEntity[] customers = {
                CustomerEntity.builder().dni("511511511L").name("Ulises").phone("666777888").email("ulises@email.com").build(),
                CustomerEntity.builder().dni("511511777L").name("Manuel").phone("666777999").email("manuel@email.com").build(),
                CustomerEntity.builder().dni("511511444M").name("Jorge").phone("666777666").email("mayoralcillo@email.com").build(),
                CustomerEntity.builder().dni("511333511A").name("Anabel").phone("666333888").email("anabelen@email.com").build(),
                CustomerEntity.builder().dni("666511511J").name("Emma").phone("666777333").email("emmatega@email.com").build()
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
                new SharedAccountEntity.Builder("ES66 123123123")
                        .amount(new BigDecimal("4000.00"))
                        .type("Family")
                        .customerEntities(List.of(customers[0], customers[1]))
                        .build(),
                new SharedAccountEntity.Builder("ES66 321321321")
                        .amount(new BigDecimal("20000.00"))
                        .type("Enterprise")
                        .customerEntities(List.of(customers[0], customers[2], customers[4]))
                        .build(),
                new SharedAccountEntity.Builder("ES66 256652256")
                        .amount((new BigDecimal("100")))
                        .customerEntities(List.of(customers[1], customers[3]))
                        .build()
        };
        this.sharedAccountRepository.saveAll(Arrays.asList(sharedAccounts));

        ShareholderEntity[] shareholders = {
                new ShareholderEntity(new BigDecimal("20.25"), new BigDecimal("1.22"), LocalDateTime.of(2020, 11, 7, 13, 30), Boolean.TRUE,
                        List.of(customers[0], customers[1], customers[4])),
                new ShareholderEntity(new BigDecimal("79.75"), new BigDecimal("2.33"), LocalDateTime.of(2020, 12, 9, 20, 15), Boolean.FALSE,
                        List.of(customers[2], customers[3]))
        };
        this.shareholderRepository.saveAll(Arrays.asList(shareholders));

    }

    public void deleteAll() {
        this.shareholderRepository.deleteAll();
        this.sharedAccountRepository.deleteAll();
        this.mortgageRepository.deleteAll();
        this.accountRepository.deleteAll();
        this.customerRepository.deleteAll();
    }
}
