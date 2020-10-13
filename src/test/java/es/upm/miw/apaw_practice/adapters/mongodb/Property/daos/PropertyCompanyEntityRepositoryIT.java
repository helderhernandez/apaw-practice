package es.upm.miw.apaw_practice.adapters.mongodb.Property.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.property.daos.PropertyCompanyRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.property.entities.PropertyCompanyEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class PropertyCompanyEntityRepositoryIT {

    @Autowired
    private PropertyCompanyRepository propertyCompanyRepository;

    @Test
    void testFindByName() {
        assertTrue(this.propertyCompanyRepository.findByName("Lancdon Property Company").isPresent());
        PropertyCompanyEntity company = this.propertyCompanyRepository.findByName("Lancdon Property Company").get();
        assertEquals("calle de vinilla,23", company.getAddress());
        assertEquals("Mainly responsible for residential properties", company.getDescription());
    }

    @Test
    void testCreateAndRead() {
        assertTrue(this.propertyCompanyRepository.findAll().stream()
                .anyMatch(company ->
                        "Yancie Property Company".equals(company.getName()) &&
                                "calle de Rubio,15".equals(company.getAddress()) &&
                                "Mainly responsible for school property properties".equals(company.getDescription())
                ));
    }
}