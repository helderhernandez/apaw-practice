package es.upm.miw.apaw_practice.domain.services.property;

import es.upm.miw.apaw_practice.domain.models.property.PropertyStaff;
import es.upm.miw.apaw_practice.domain.models.property.PropertyStaffCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.property.PropertyStaffPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyStaffService {
    private final PropertyStaffPersistence propertyStaffPersistence;

    @Autowired
    public PropertyStaffService(PropertyStaffPersistence propertyStaffPersistence) {
        this.propertyStaffPersistence = propertyStaffPersistence;
    }

    public PropertyStaff create(PropertyStaffCreation propertyStaffCreation) {
        return this.propertyStaffPersistence.create(propertyStaffCreation);
    }
}