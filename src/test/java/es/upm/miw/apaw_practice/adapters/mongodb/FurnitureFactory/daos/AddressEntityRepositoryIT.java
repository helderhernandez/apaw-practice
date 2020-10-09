package es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities.AddressEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class AddressEntityRepositoryIT {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    void testFindByCountry() {
        assertTrue(this.addressRepository.findByCountry("China").isPresent());
        AddressEntity address = this.addressRepository.findByCountry("China").get();
        assertEquals("China", address.getCountry());
        assertEquals("Taizhou", address.getCity());
        assertEquals("Jiaojiang", address.getStreet());
    }

    @Test
    void testCreateAndRead() {
        assertTrue(this.addressRepository.findAll().stream()
                .anyMatch(address ->
                        "China".equals(address.getCountry()) &&
                                "Taizhou".equals(address.getCity()) &&
                                "Jiaojiang".equals(address.getStreet())&&
                                address.getId() != null
                ));
    }

}
