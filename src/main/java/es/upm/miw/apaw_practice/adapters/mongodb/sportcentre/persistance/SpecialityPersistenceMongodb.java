package es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.persistance;

import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.daos.SpecialityRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities.SpecialityEntity;
import es.upm.miw.apaw_practice.domain.models.sportcentre.Speciality;
import es.upm.miw.apaw_practice.domain.persistence_ports.sportcentre.SpecialityPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
                .map(specialityEntity -> specialityEntity.toSpeciality());
    }

}
