package es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.daos.AddressRepository;
import es.upm.miw.apaw_practice.domain.persistence_ports.FurnitureFactory.AddressPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("addressPersistence")
public class AddressPersistenceMongodb implements AddressPersistence {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressPersistenceMongodb( AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void deleteById(String id) {
        this.addressRepository.deleteById(id);
    }
}
