package es.upm.miw.apaw_practice.adapters.mongodb.property.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.property.daos.PropertyCompanyRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.property.entities.PropertyCompanyEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.property.PropertyCompany;
import es.upm.miw.apaw_practice.domain.persistence_ports.property.PropertyCompanyPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("propertyCompanyPersistence")
public class PropertyCompanyPersistenceMongodb implements PropertyCompanyPersistence {

    private final PropertyCompanyRepository propertyCompanyRepository;

    @Autowired
    public PropertyCompanyPersistenceMongodb(PropertyCompanyRepository propertyCompanyRepository) {
        this.propertyCompanyRepository = propertyCompanyRepository;
    }

    public Stream<PropertyCompany> readAll() {
        return this.propertyCompanyRepository.findAll().stream()
                .map(PropertyCompanyEntity::toPropertyCompany);
    }

    public PropertyCompany updateName(String name) {
        PropertyCompanyEntity propertyCompanyEntity = this.propertyCompanyRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("PropertyCompany Name: " + name));
        //PropertyCompanyEntity.setName(name);
        return this.propertyCompanyRepository.save(propertyCompanyEntity).toPropertyCompany();
    }
}