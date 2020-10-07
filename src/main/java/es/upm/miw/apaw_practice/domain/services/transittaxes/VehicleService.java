package es.upm.miw.apaw_practice.domain.services.transittaxes;

import es.upm.miw.apaw_practice.domain.models.transittaxes.Vehicle;
import es.upm.miw.apaw_practice.domain.persistence_ports.transittaxes.VehiclePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    private VehiclePersistence vehiclePersistence;

    @Autowired
    public VehicleService(VehiclePersistence vehiclePersistence) {
        this.vehiclePersistence = vehiclePersistence;
    }

    public Vehicle updateBrand(String id, String brand) {
        return vehiclePersistence.updateBrand(id, brand);
    }
}
