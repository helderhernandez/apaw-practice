package es.upm.miw.apaw_practice.adapters.mongodb.hospital.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos.IllnessRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.IllnessEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.hospital.Illness;
import es.upm.miw.apaw_practice.domain.persistence_ports.hospital.IllnessPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("illnessPersistence")
public class IllnessPersistenceMongodb implements IllnessPersistence {

    private IllnessRepository illnessRepository;

    @Autowired
    public IllnessPersistenceMongodb(IllnessRepository illnessRepository){
        this.illnessRepository=illnessRepository;
    }

    @Override
    public Stream<Illness> readAll() {
        return this.illnessRepository.findAll().stream()
                .map(IllnessEntity::toIllness);
    }

    @Override
    public Stream<Illness> readByPhase(Integer phase) {
        return this.illnessRepository.findByPhase(phase)
                .orElseThrow(()->new NotFoundException("Illness phase: " + phase))
                .stream()
                .map(IllnessEntity::toIllness);
    }

    @Override
    public Illness update(Illness illness) {
        IllnessEntity illnessEntity = this.illnessRepository
                .findById(illness.getId())
                .orElseThrow(()->new NotFoundException("Illness id: " + illness.getId()));
        illnessEntity.fromIllness(illness);
        return this.illnessRepository
                .save(illnessEntity)
                .toIllness();
    }
}
