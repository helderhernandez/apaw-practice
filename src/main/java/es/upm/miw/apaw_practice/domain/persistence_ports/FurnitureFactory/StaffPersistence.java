package es.upm.miw.apaw_practice.domain.persistence_ports.FurnitureFactory;
import es.upm.miw.apaw_practice.domain.models.FurnitureFactory.Staff;
import es.upm.miw.apaw_practice.domain.models.school.Student;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface StaffPersistence {
    Staff create(Staff staff);
    Stream<Staff> findFirstNameByWarehouseName(String warehouseName);
}
