package es.upm.miw.apaw_practice.adapters.mongodb.bank.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.BankSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.ShareholderRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.ShareholderEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class ShareholderPersistenceMongodbIT {

    @Autowired
    private ShareholderPersistenceMongodb shareholderPersistence;

    @Autowired
    private ShareholderRepository shareholderRepository;

    @Autowired
    private BankSeederService bankSeederService;

    @Test
    void testUpdateExpirationDates() {
        LocalDateTime date = LocalDateTime.of(2023, 11, 7, 17, 45);
        this.shareholderPersistence.updateExpirationDates(date);
        this.shareholderRepository.findAll().stream()
                .map(item -> {
                    assertEquals(item.getExpirationDate(), date);
                    return item;
                });
        bankSeederService.deleteAll();
        bankSeederService.seedDatabase();
    }

    @Test
    void testFindValueGreaterThan() {
        BigDecimal value = new BigDecimal("1.50");
        shareholderPersistence.findValueGraterThan(value).stream()
                .map(ShareholderEntity::getValue)
                .forEach(val -> assertEquals(val.compareTo(value), 1));
    }
}
