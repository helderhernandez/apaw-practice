package es.upm.miw.apaw_practice.domain.services.sportcentre;


import es.upm.miw.apaw_practice.domain.models.sportcentre.Speciality;
import es.upm.miw.apaw_practice.domain.persistence_ports.sportcentre.SpecialityPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class SpecialityService {

    private SpecialityPersistence specialityPersistence;

    @Autowired
    public SpecialityService(SpecialityPersistence specialityPersistence) {
        this.specialityPersistence = specialityPersistence;
    }

    public Stream<Speciality> readAll() {
        return this.specialityPersistence.readAll();
    }

}
