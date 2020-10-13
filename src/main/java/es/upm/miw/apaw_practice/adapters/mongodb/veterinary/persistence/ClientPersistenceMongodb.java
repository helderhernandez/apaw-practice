package es.upm.miw.apaw_practice.adapters.mongodb.veterinary.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.daos.ClientRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.entities.ClientEntity;
import es.upm.miw.apaw_practice.domain.models.veterinary.Client;
import es.upm.miw.apaw_practice.domain.persistence_ports.veterinary.ClientPersistence;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("clientPersistence")
public class ClientPersistenceMongodb implements ClientPersistence {

    private final ClientRepository clientRepository;

    public ClientPersistenceMongodb(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Stream<Client> readAll() {
        return this.clientRepository.findAll().stream()
                .map(ClientEntity::toClient);
    }
}
