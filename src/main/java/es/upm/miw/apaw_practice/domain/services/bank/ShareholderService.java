package es.upm.miw.apaw_practice.domain.services.bank;

import es.upm.miw.apaw_practice.domain.persistence_ports.bank.ShareholderPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ShareholderService {

    private final ShareholderPersistence shareholderPersistence;

    @Autowired
    public ShareholderService(ShareholderPersistence shareholderPersistence) {
        this.shareholderPersistence = shareholderPersistence;
    }

    public void updateExpirationDates(LocalDateTime localDateTime) {
        this.shareholderPersistence.updateExpirationDates(localDateTime);
    }
}
