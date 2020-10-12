package es.upm.miw.apaw_practice.adapters.mongodb.veterinary.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.daos.VeterinaryRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.entities.VeterinaryEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.veterinary.Veterinary;
import es.upm.miw.apaw_practice.domain.persistence_ports.veterinary.VeterinaryPersistence;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("veterinaryPersistence")
public class VeterinaryPersistenceMongodb implements VeterinaryPersistence {

    private final VeterinaryRepository veterinaryRepository;

    public VeterinaryPersistenceMongodb(VeterinaryRepository veterinaryRepository) {
        this.veterinaryRepository = veterinaryRepository;
    }

    @Override
    public Stream<Veterinary> readAll() {
        return this.veterinaryRepository.findAll().stream()
                .map(VeterinaryEntity::toVeterinary);
    }

    @Override
    public Veterinary readById(String id) {
        return this.veterinaryRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Animal ID: " + id))
                .toVeterinary();
    }

}
