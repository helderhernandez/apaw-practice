package es.upm.miw.apaw_practice.adapters.mongodb.bank.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.ShareholderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class ShareholderPersistenceMongodbIT {

    @Autowired
    private ShareholderPersistenceMongodb shareholderPersistence;

    @Autowired
    private ShareholderRepository shareholderRepository;

    @Test
    void testUpdateExpirationDates() {
        LocalDateTime date = LocalDateTime.of(2023, 11, 7, 17, 45);
        this.shareholderPersistence.updateExpirationDates(date);
        this.shareholderRepository.findAll().stream()
                .map(item -> {
                    assertEquals(item.getExpirationDate(), date);
                    return item;
                });

    }
}
