package es.upm.miw.apaw_practice.adapters.mongodb.bank.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.SharedAccountEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;


@TestConfig
public class SharedAccountEntityRepositoryIT {

    @Autowired
    private SharedAccountRepository sharedAccountRepository;

    @Test
    void testFindByIBAN() {
        assertTrue(this.sharedAccountRepository.findByIBAN("ES66 123123123").isPresent());
        SharedAccountEntity sharedAccount = this.sharedAccountRepository.findByIBAN("ES66 123123123").get();
        assertTrue(sharedAccount.getAmount().equals(new BigDecimal("4000.00")));
    }

    @Test
    void testCreateAndRead() {
        assertTrue(this.sharedAccountRepository.findAll().stream()
                .anyMatch(shared ->
                        new BigDecimal("4000.00").equals(shared.getAmount()) &&
                                "Family".equals(shared.getType()) &&
                                shared.getId() != null &&
                                2 == shared.getCustomerEntities().size() &&
                                "Ulises".equals(shared.getCustomerEntities().get(0).getName()) &&
                                "511511511L".equals(shared.getCustomerEntities().get(0).getDNI()) &&
                                "666777888".equals(shared.getCustomerEntities().get(0).getPhone()) &&
                                "ulises@email.com".equals(shared.getCustomerEntities().get(0).getEmail())
                )
        );
    }


}
