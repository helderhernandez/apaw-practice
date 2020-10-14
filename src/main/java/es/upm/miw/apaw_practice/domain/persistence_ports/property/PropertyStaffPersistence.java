package es.upm.miw.apaw_practice.domain.persistence_ports.property;

import es.upm.miw.apaw_practice.domain.models.property.PropertyStaff;
import es.upm.miw.apaw_practice.domain.models.property.PropertyStaffCreation;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyStaffPersistence {
    PropertyStaff create(PropertyStaffCreation propertyStaffCreation);
}