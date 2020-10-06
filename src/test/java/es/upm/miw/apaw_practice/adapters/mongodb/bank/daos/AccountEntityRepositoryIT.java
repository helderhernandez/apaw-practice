package es.upm.miw.apaw_practice.adapters.mongodb.bank.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.AccountEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class AccountEntityRepositoryIT {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void testFindByIBAN() {
        assertTrue(this.accountRepository.findByIBAN("ES66 987651234").isPresent());
        AccountEntity account = this.accountRepository.findByIBAN("ES66 987651234").get();
        assertEquals(new BigDecimal("68.54"), account.getAmount());
    }

    @Test
    void testAndCreate() {
        assertTrue(this.accountRepository.findAll().stream()
                .anyMatch(account ->
                        "ES66 987651234".equals(account.getIBAN()) &&
                                new BigDecimal("68.54").equals(account.getAmount()) &&
                                account.getId() != null &&
                                "511511511L".equals(account.getCustomerEntity().getDNI()) &&
                                "Ulises".equals(account.getCustomerEntity().getName()) &&
                                "666777888".equals(account.getCustomerEntity().getPhone()) &&
                                "ulises@email.com".equals(account.getCustomerEntity().getEmail())
                ));
    }

}
