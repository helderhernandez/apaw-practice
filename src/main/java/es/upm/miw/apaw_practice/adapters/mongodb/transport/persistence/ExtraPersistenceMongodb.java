package es.upm.miw.apaw_practice.adapters.mongodb.transport.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.transport.daos.ExtraRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.transport.entities.ExtraEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.school.Student;
import es.upm.miw.apaw_practice.domain.models.transport.Extra;
import es.upm.miw.apaw_practice.domain.persistence_ports.transport.ExtraPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("extraPersistence")
public class ExtraPersistenceMongodb implements ExtraPersistence {

    private ExtraRepository extraRepository;

    @Autowired
    public ExtraPersistenceMongodb(ExtraRepository extraRepository) {
        this.extraRepository = extraRepository;
    }

    @Override
    public Extra update(Extra extra) {
        ExtraEntity extraEntity = this.extraRepository
                .findById(extra.getId())
                .orElseThrow(() -> new NotFoundException("Extra id: " + extra.getId()));
        extraEntity.fromStudent(extra);
        return this.extraRepository
                .save(extraEntity)
                .toExtra();
    }

    @Override
    public Extra findById(String id) {
        return this.extraRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("ShoppingCart id:" + id))
                .toExtra();
    }

    @Override
    public Stream<Extra> readAll() {
        return this.extraRepository.findAll().stream()
                .map(ExtraEntity::toExtra);    }

    @Override
    public void deleteById(String id) {
        this.extraRepository.deleteById(id);
    }
}
