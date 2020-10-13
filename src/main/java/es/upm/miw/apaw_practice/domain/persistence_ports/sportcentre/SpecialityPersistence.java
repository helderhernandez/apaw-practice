package es.upm.miw.apaw_practice.domain.persistence_ports.sportcentre;

import es.upm.miw.apaw_practice.domain.models.sportcentre.Speciality;
import org.springframework.stereotype.Repository;


import java.util.stream.Stream;

@Repository
public interface SpecialityPersistence {

    Stream<Speciality> readAll();

    Speciality findById(String id);

    Speciality update(Speciality speciality);
}
