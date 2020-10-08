package es.upm.miw.apaw_practice.adapters.mongodb.bank.persistence;


import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.ShareholderRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.ShareholderEntity;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.ShareholderPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Repository("shareholderPersistence")
public class ShareholderPersistenceMongodb implements ShareholderPersistence {

    private final ShareholderRepository shareholderRepository;

    @Autowired
    public ShareholderPersistenceMongodb(ShareholderRepository shareholderRepository) {
        this.shareholderRepository = shareholderRepository;
    }

    @Override
    public void updateExpirationDates(LocalDateTime localDateTime) {
        List<ShareholderEntity> shareholders = this.shareholderRepository.findAll().stream()
                .map(item -> {
                    item.setExpirationDate(localDateTime);
                    return item;
                }).collect(Collectors.toList());
        this.shareholderRepository.saveAll(shareholders);

    }
}
