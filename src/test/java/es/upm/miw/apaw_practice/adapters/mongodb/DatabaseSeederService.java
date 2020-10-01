package es.upm.miw.apaw_practice.adapters.mongodb;

import es.upm.miw.apaw_practice.adapters.mongodb.factory.FactorySeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.KitchenSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.shop.ShopSeederService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseSeederService {

    private ShopSeederService shopSeederService;
    private FactorySeederService factorySeederService;
    private KitchenSeederService kitchenSeederService;

    @Autowired
    public DatabaseSeederService(ShopSeederService shopSeederService, FactorySeederService factorySeederService,
                                 KitchenSeederService kitchenSeederService) {
        this.shopSeederService = shopSeederService;
        this.factorySeederService = factorySeederService;
        this.kitchenSeederService = kitchenSeederService;
        this.seedDatabase();
    }

    public void seedDatabase() {
        this.shopSeederService.seedDatabase();
        this.factorySeederService.seedDatabase();
        this.kitchenSeederService.seedDatabase();
    }

    public void deleteAll() {
        this.shopSeederService.deleteAll();
        this.factorySeederService.deleteAll();
        this.kitchenSeederService.deleteAll();
    }

    public void reSeedDatabase() {
        this.deleteAll();
        this.seedDatabase();
    }
}
