package es.upm.miw.apaw_practice.adapters.mongodb.airport.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.airport.daos.PlaneRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.PlaneEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.airport.Plane;
import es.upm.miw.apaw_practice.domain.models.airport.PlaneCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.airport.PlanePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("planePersistence")
public class PlanePersistenceMongodb implements PlanePersistence {

    private PlaneRepository planeRepository;

    @Autowired
    public PlanePersistenceMongodb(PlaneRepository planeRepository) {
        this.planeRepository = planeRepository;
    }

    @Override
    public Plane create(PlaneCreation planeCreation) {
        this.assertLicensePlateNotExist(planeCreation.getLicensePlate());
        return this.planeRepository
                .save(new PlaneEntity(planeCreation))
                .toPlane();
    }

    @Override
    public Plane updateCapacity(String id, Integer capacity) {
        PlaneEntity planeEntity = this.planeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Plane id: " + id));
        planeEntity.setCapacity(capacity);
        return this.planeRepository.save(planeEntity).toPlane();
    }

    private void assertLicensePlateNotExist(String licensePlate) {
        this.planeRepository.findByLicensePlate(licensePlate)
                .ifPresent(planeEntity -> {
                    throw new ConflictException("LicensePlate exist: " + licensePlate);
                });
    }
}
