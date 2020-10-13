package es.upm.miw.apaw_practice.domain.persistence_ports.property;

import es.upm.miw.apaw_practice.domain.models.property.PropertyCompany;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface PropertyCompanyPersistence {
    PropertyCompany updateName(String name);
    Stream<PropertyCompany> readAll();
}