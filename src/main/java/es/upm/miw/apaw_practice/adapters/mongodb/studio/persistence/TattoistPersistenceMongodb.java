package es.upm.miw.apaw_practice.adapters.mongodb.studio.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.studio.daos.TattoistRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.studio.entities.TattoistEntity;
import es.upm.miw.apaw_practice.domain.models.studio.Tattoist;
import es.upm.miw.apaw_practice.domain.persistence_ports.studio.TattoistPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("tattoistPersistence")
public class TattoistPersistenceMongodb implements TattoistPersistence {

    private final TattoistRepository tattoistRepository;

    @Autowired
    public TattoistPersistenceMongodb(TattoistRepository tattoistRepository) {
        this.tattoistRepository = tattoistRepository;
    }

    @Override
    public Stream<Tattoist> readAll() {
        return this.tattoistRepository
                .findAll()
                .stream()
                .map(TattoistEntity::toTattoist);
    }
}
