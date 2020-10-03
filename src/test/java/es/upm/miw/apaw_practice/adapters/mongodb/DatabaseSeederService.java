package es.upm.miw.apaw_practice.adapters.mongodb;

import es.upm.miw.apaw_practice.adapters.mongodb.factory.FactorySeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.shop.ShopSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.VeterinarySeederService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseSeederService {

    private ShopSeederService shopSeederService;
    private FactorySeederService factorySeederService;
    private VeterinarySeederService veterinarySeederService;

    @Autowired
    public DatabaseSeederService(ShopSeederService shopSeederService, FactorySeederService factorySeederService, VeterinarySeederService veterinarySeederService) {
        this.shopSeederService = shopSeederService;
        this.factorySeederService = factorySeederService;
        this.veterinarySeederService=veterinarySeederService;
        this.seedDatabase();
    }

    public void seedDatabase() {
        this.shopSeederService.seedDatabase();
        this.factorySeederService.seedDatabase();
        this.veterinarySeederService.seedDatabase();
    }

    public void deleteAll() {
        this.shopSeederService.deleteAll();
        this.factorySeederService.deleteAll();
        this.veterinarySeederService.deleteAll();
    }

    public void reSeedDatabase() {
        this.deleteAll();
        this.seedDatabase();
    }
}
