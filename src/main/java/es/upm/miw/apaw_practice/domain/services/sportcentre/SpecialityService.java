package es.upm.miw.apaw_practice.domain.services.sportcentre;

import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities.SpecialityEntity;
import es.upm.miw.apaw_practice.domain.models.sportcentre.DurationsUpdating;
import es.upm.miw.apaw_practice.domain.models.sportcentre.Speciality;
import es.upm.miw.apaw_practice.domain.persistence_ports.sportcentre.SpecialityPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public void updateDurations(List<DurationsUpdating> listDurations) {
        listDurations.stream()
                .map(item -> {
                    Speciality speciality = this.specialityPersistence
                            .findById(item.getId());
                    speciality.setDuration(item.getDuration());
                    return speciality;
                })
                .forEach(speciality -> this.specialityPersistence.update(speciality));
    }
}
