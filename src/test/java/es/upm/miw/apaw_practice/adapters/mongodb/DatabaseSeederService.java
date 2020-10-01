package es.upm.miw.apaw_practice.adapters.mongodb;

import es.upm.miw.apaw_practice.adapters.mongodb.factory.FactorySeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.project.ProjectSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.shop.ShopSeederService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseSeederService {

    private ShopSeederService shopSeederService;
    private FactorySeederService factorySeederService;
    private ProjectSeederService projectSeederService;

    @Autowired
    public DatabaseSeederService(ShopSeederService shopSeederService, FactorySeederService factorySeederService, ProjectSeederService projectSeederService) {
        this.shopSeederService = shopSeederService;
        this.factorySeederService = factorySeederService;
        this.projectSeederService = projectSeederService;
        this.seedDatabase();
    }

    public void seedDatabase() {
        this.shopSeederService.seedDatabase();
        this.factorySeederService.seedDatabase();
        this.projectSeederService.seedDatabase();
    }

    public void deleteAll() {
        this.shopSeederService.deleteAll();
        this.factorySeederService.deleteAll();
        this.projectSeederService.deleteAll();
    }

    public void reSeedDatabase() {
        this.deleteAll();
        this.seedDatabase();
    }
}
