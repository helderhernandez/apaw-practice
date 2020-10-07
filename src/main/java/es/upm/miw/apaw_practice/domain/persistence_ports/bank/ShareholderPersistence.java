package es.upm.miw.apaw_practice.domain.persistence_ports.bank;

import java.time.LocalDateTime;

public interface ShareholderPersistence {
    void updateExpirationDates(LocalDateTime localDateTime);
}
