package es.upm.miw.apaw_practice.adapters.mongodb.veterinary.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.daos.AnimalRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.daos.SurgeryRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.daos.VeterinaryRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.entities.SurgeryEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.entities.VeterinaryEntity;
import es.upm.miw.apaw_practice.domain.models.veterinary.Surgery;
import es.upm.miw.apaw_practice.domain.persistence_ports.veterinary.SurgeryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository("surgeryPersistence")
public class SurgeryPersistenceMongodb implements SurgeryPersistence {

    private final SurgeryRepository surgeryRepository;
    private final AnimalRepository animalRepository;
    private final VeterinaryRepository veterinaryRepository;

    @Autowired
    public SurgeryPersistenceMongodb(SurgeryRepository surgeryRepository, AnimalRepository animalRepository, VeterinaryRepository veterinaryRepository) {
        this.surgeryRepository = surgeryRepository;
        this.animalRepository = animalRepository;
        this.veterinaryRepository = veterinaryRepository;
    }

    @Override
    public Stream<Surgery> readAll() {
        return this.surgeryRepository.findAll().stream()
                .map(SurgeryEntity::toSurgery);
    }

    public List<String> findAnimalByName(String name) {
        List<SurgeryEntity> surgeries = this.surgeryRepository.findAll().stream()
                .filter(surgery -> surgery.getAnimals().stream().allMatch(animal -> animal.getName().equals(name)))
                .collect(Collectors.toList());
        return surgeries.stream()
                .flatMap(veterinary -> veterinary.getVeterinarians().stream().map(VeterinaryEntity::getName))
                .collect(Collectors.toList());

    }
}
