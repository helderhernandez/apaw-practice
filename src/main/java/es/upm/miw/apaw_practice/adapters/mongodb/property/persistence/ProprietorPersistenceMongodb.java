package es.upm.miw.apaw_practice.adapters.mongodb.property.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.property.daos.ProprietorRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.property.entities.ProprietorEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.property.Proprietor;
import es.upm.miw.apaw_practice.domain.persistence_ports.property.ProprietorPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("proprietorPersistence")
public class ProprietorPersistenceMongodb implements ProprietorPersistence {
    private final ProprietorRepository proprietorRepository;

    @Autowired
    public ProprietorPersistenceMongodb(ProprietorRepository proprietorRepository) {
        this.proprietorRepository = proprietorRepository;
    }

    public Stream<Proprietor> readAll() {
        return this.proprietorRepository.findAll().stream()
                .map(proprietorEntity -> proprietorEntity.toProprietor());
    }

    //@Override
    public Proprietor update(Proprietor proprietor) {
        ProprietorEntity proprietorEntity = this.proprietorRepository
                .findByDni(proprietor.getDni())
                .orElseThrow(() -> new NotFoundException("Proprietor dni: " + proprietor.getDni()));
        proprietorEntity.fromProprietor(proprietor);
        return this.proprietorRepository
                .save(proprietorEntity)
                .toProprietor();
    }

    //@Override
    public Proprietor readByDni(String dni) {
        return this.proprietorRepository
                .findByDni(dni)
                .orElseThrow(() -> new NotFoundException("Student dni: " + dni))
                .toProprietor();
    }
}

