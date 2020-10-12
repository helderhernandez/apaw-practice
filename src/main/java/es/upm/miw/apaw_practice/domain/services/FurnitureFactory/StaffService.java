package es.upm.miw.apaw_practice.domain.services.FurnitureFactory;


import es.upm.miw.apaw_practice.domain.models.FurnitureFactory.Staff;
import es.upm.miw.apaw_practice.domain.persistence_ports.FurnitureFactory.StaffPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffService {

    private final StaffPersistence staffPersistence;

    @Autowired
    public StaffService(StaffPersistence staffPersistence) {
        this.staffPersistence = staffPersistence;
    }

    public Staff create(Staff staff) {
        return this.staffPersistence.create(staff);
    }


}
