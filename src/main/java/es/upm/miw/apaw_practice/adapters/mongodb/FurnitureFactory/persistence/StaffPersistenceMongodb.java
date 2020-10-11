package es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.daos.StaffRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities.StaffEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.FurnitureFactory.Staff;
import es.upm.miw.apaw_practice.domain.persistence_ports.FurnitureFactory.StaffPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("staffPersistence")
public class StaffPersistenceMongodb implements StaffPersistence {
    private final StaffRepository staffRepository;

    @Autowired
    public StaffPersistenceMongodb(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public void assertDniNotExist(String dni) {
        this.staffRepository
                .findByDni(dni)
                .ifPresent(staff -> {
                    throw new ConflictException("Dni exist: " + dni);
                });
    }

    @Override
    public Staff create(Staff staff) {
        this.assertDniNotExist(staff.getDni());
        return this.staffRepository
                .save(new StaffEntity(staff))
                .toWorker();
    }
}
