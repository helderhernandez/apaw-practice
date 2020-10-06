package es.upm.miw.apaw_practice.adapters.mongodb.bank.persistence;


import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.BankSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.AccountRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.AccountEntity;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.AccountPersistence;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
public class AccountPersistenceMongodbIT {

    @Autowired
    private AccountPersistence accountPersistence;

    @Autowired
    private BankSeederService bankSeederService;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void testUpdateAmount() {
        AccountEntity accountEntity = this.accountRepository
                .findByIBAN("ES66 987651234")
                .get();
        assertNotNull(accountEntity.getId());
        this.accountPersistence.updateAmount(accountEntity.getId(), new BigDecimal("100.00"));
        assertEquals(new BigDecimal("100.00"),
                accountRepository.findByIBAN("ES66 987651234").get().getAmount());
        bankSeederService.deleteAll();
        bankSeederService.seedDatabase();
    }
}
