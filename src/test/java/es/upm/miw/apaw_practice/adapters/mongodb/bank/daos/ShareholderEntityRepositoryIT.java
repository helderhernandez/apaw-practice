package es.upm.miw.apaw_practice.adapters.mongodb.bank.daos;


import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class ShareholderEntityRepositoryIT {

    @Autowired
    private ShareholderRepository shareholderRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.shareholderRepository.findAll().stream()
                .anyMatch(shareholder ->
                        new BigDecimal("20.25").equals(shareholder.getPercentage()) &&
                                new BigDecimal("1.22").equals(shareholder.getValue()) &&
                                LocalDateTime.of(2020, 11, 7, 13, 30).equals(shareholder.getExpirationDate()) &&
                                shareholder.getActive() &&
                                shareholder.getId() != null &&
                                "Ulises".equals(shareholder.getCustomerEntities().get(0).getName()) &&
                                "511511511L".equals(shareholder.getCustomerEntities().get(0).getDNI()) &&
                                "666777888".equals(shareholder.getCustomerEntities().get(0).getPhone()) &&
                                "ulises@email.com".equals(shareholder.getCustomerEntities().get(0).getEmail())
                )
        );
    }

}
