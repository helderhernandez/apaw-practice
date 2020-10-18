package es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.daos.StaffRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.daos.WarehouseRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities.StaffEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.FurnitureFactory.Staff;
import es.upm.miw.apaw_practice.domain.models.transittaxes.Accident;
import es.upm.miw.apaw_practice.domain.persistence_ports.FurnitureFactory.StaffPersistence;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.stream.Stream;

@Repository("staffPersistence")
public class StaffPersistenceMongodb implements StaffPersistence {
    private final StaffRepository staffRepository;
    private final WarehouseRepository warehouseRepository;
    @Autowired
    public StaffPersistenceMongodb(StaffRepository staffRepository, WarehouseRepository warehouseRepository) {
        this.staffRepository = staffRepository;
        this.warehouseRepository = warehouseRepository;
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
                .toStaff();
    }
    @Override
    public Stream<Staff> findFirstNameByWarehouseName(String warehouseName) {
        return FirstNameByWarehouseName(warehouseName)
                .map(firstName -> {
                    Staff a = new Staff();
                    a.setFirstName(firstName);
                    return a;
                });
    }


    public Stream<String> FirstNameByWarehouseName(String warehouseName) {
        return this.warehouseRepository.findAll()
                .stream()
                .filter( warehouseEntity-> warehouseEntity.getName().equals(warehouseName))
                .peek(warehouseEntity -> LogManager.getLogger(this.getClass()).info("warehouseEntity name: " + warehouseEntity.getName()))
                .flatMap(warehouseEntity->warehouseEntity.getStaffEntities().stream())
                .map(StaffEntity->StaffEntity.toStaff().getFirstName());
    }

}
