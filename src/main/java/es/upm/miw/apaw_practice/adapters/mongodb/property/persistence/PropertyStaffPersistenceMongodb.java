package es.upm.miw.apaw_practice.adapters.mongodb.property.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.property.daos.PropertyStaffRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.property.entities.PropertyStaffEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.property.PropertyStaff;
import es.upm.miw.apaw_practice.domain.models.property.PropertyStaffCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.property.PropertyStaffPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("propertyStaffPersistence")
public class PropertyStaffPersistenceMongodb implements PropertyStaffPersistence {
    private final PropertyStaffRepository propertyStaffRepository;

    @Autowired
    public PropertyStaffPersistenceMongodb(PropertyStaffRepository propertyStaffRepository){
        this.propertyStaffRepository = propertyStaffRepository;
    }

    public void assertDniNotExist(String dni){
        this.propertyStaffRepository
                .findByDni(dni)
                .ifPresent(article -> {
                    throw new ConflictException("Dni exist: " + dni);
                });
    }

    @Override
    public PropertyStaff create(PropertyStaffCreation propertyStaffCreation){
        this.assertDniNotExist(propertyStaffCreation.getId());
        return this.propertyStaffRepository
                .save(new PropertyStaffEntity(propertyStaffCreation))
                .toPropertyStaff();
    }
}