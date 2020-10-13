package es.upm.miw.apaw_practice.domain.services.kitchen;

import es.upm.miw.apaw_practice.domain.persistence_ports.kitchen.KitchenBoyPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KitchenBoyService {
    private KitchenBoyPersistence kitchenBoyPersistence;

    @Autowired
    public KitchenBoyService(KitchenBoyPersistence kitchenBoyPersistence) {
        this.kitchenBoyPersistence = kitchenBoyPersistence;
    }

    public void delete(String dni) {
        this.kitchenBoyPersistence.delete(dni);
    }
}
