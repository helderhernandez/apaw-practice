package es.upm.miw.apaw_practice.domain.services.FurnitureFactory;
import es.upm.miw.apaw_practice.domain.persistence_ports.FurnitureFactory.AddressPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private final AddressPersistence addressPersistence;

    @Autowired
    public AddressService(AddressPersistence addressPersistence) {
        this.addressPersistence = addressPersistence;
    }

    public void delete(String id) {
        this.addressPersistence.deleteById(id);
    }

}
