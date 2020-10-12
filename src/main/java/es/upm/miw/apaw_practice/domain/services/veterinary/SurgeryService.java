package es.upm.miw.apaw_practice.domain.services.veterinary;

import es.upm.miw.apaw_practice.domain.models.veterinary.Surgery;
import es.upm.miw.apaw_practice.domain.persistence_ports.veterinary.AnimalPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.veterinary.SurgeryPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.veterinary.VeterinaryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class SurgeryService {

    private SurgeryPersistence surgeryPersistence;
    private AnimalPersistence animalPersistence;
    private VeterinaryPersistence veterinaryPersistence;

    @Autowired
    public SurgeryService(SurgeryPersistence surgeryPersistence, AnimalPersistence animalPersistence, VeterinaryPersistence veterinaryPersistence) {
        this.surgeryPersistence = surgeryPersistence;
        this.animalPersistence = animalPersistence;
        this.veterinaryPersistence = veterinaryPersistence;
    }

    public Stream<Surgery> readAll() {
        return this.surgeryPersistence.readAll();
    }
}
