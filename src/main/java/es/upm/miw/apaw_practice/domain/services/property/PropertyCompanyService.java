package es.upm.miw.apaw_practice.domain.services.property;

import es.upm.miw.apaw_practice.domain.models.property.PropertyCompany;
import es.upm.miw.apaw_practice.domain.persistence_ports.property.PropertyCompanyPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class PropertyCompanyService {
    private final PropertyCompanyPersistence propertyCompanyPersistence;

    @Autowired
    public PropertyCompanyService(PropertyCompanyPersistence propertyCompanyPersistence) {
        this.propertyCompanyPersistence = propertyCompanyPersistence;
    }

    public PropertyCompany updateName(String name) {
        return this.propertyCompanyPersistence.updateName(name);
    }

    public Stream<PropertyCompany> readAll() {
        return this.propertyCompanyPersistence.readAll();
    }
}