package es.upm.miw.apaw_practice.adapters.mongodb.bank.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.SharedAccountRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.SharedAccountEntity;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.SharedAccountPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository("sharedAccountPersistence")
public class SharedAccountPersistenceMongodb implements SharedAccountPersistence {

    private final SharedAccountRepository sharedAccountRepository;

    @Autowired
    public SharedAccountPersistenceMongodb(SharedAccountRepository sharedAccountRepository) {
        this.sharedAccountRepository = sharedAccountRepository;
    }

    public List<String> findDNIBySharedAccount() {
        return this.sharedAccountRepository.findAll().stream()
                .flatMap(SharedAccountEntity::getDNIs)
                .distinct()
                .collect(Collectors.toList());
    }
}
