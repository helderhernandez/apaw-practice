package es.upm.miw.apaw_practice.domain.persistence_ports.FurnitureFactory;
import es.upm.miw.apaw_practice.domain.models.FurnitureFactory.Staff;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffPersistence {
    Staff create(Staff staff);
}
