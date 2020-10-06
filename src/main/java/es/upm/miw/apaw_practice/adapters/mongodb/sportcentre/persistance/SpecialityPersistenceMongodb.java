package es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.persistance;

import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.daos.SpecialityRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities.SpecialityEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.sportcentre.DurationsUpdating;
import es.upm.miw.apaw_practice.domain.models.sportcentre.Speciality;
import es.upm.miw.apaw_practice.domain.persistence_ports.sportcentre.SpecialityPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository("specialityPersistence")
public class SpecialityPersistenceMongodb implements SpecialityPersistence {

    private SpecialityRepository specialityRepository;


    @Autowired
    public SpecialityPersistenceMongodb(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Stream<Speciality> readAll() {
        return this.specialityRepository.findAll().stream()
                .map(SpecialityEntity::toSpeciality);
    }

    @Override
    public Speciality findById(String id) {
        return this.specialityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Speciality id: " + id))
                .toSpeciality();
    }

    @Override
    public Speciality update(Speciality speciality) {
        SpecialityEntity specialityEntity = this.specialityRepository
                .findById(speciality.getId())
                .orElseThrow(() -> new NotFoundException("Speciality id: " + speciality.getId()));
        specialityEntity.fromSpeciality(speciality);
        return this.specialityRepository.save(specialityEntity).toSpeciality();
    }

}
