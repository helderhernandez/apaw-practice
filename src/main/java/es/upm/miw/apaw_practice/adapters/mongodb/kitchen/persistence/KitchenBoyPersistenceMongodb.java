package es.upm.miw.apaw_practice.adapters.mongodb.kitchen.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.daos.KitchenBoyRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.entities.KitchenBoyEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.persistence_ports.kitchen.KitchenBoyPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("kitchenBoyPersistence")
public class KitchenBoyPersistenceMongodb implements KitchenBoyPersistence {
    private KitchenBoyRepository kitchenBoyRepository;

    @Autowired
    public KitchenBoyPersistenceMongodb(KitchenBoyRepository kitchenBoyRepository) {
        this.kitchenBoyRepository = kitchenBoyRepository;
    }


    @Override
    public void delete(String dni) {
        KitchenBoyEntity kitchenBoy = this.kitchenBoyRepository.findByDni(dni)
                .orElseThrow(() -> new NotFoundException("KitchenBoy dni:" + dni));
        this.kitchenBoyRepository.delete(kitchenBoy);
    }


}
