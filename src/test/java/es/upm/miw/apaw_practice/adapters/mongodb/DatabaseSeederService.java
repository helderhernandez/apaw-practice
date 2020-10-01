package es.upm.miw.apaw_practice.adapters.mongodb;

import es.upm.miw.apaw_practice.adapters.mongodb.factory.FactorySeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.movie.MovieSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.shop.ShopSeederService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseSeederService {

    private ShopSeederService shopSeederService;
    private FactorySeederService factorySeederService;
    private MovieSeederService movieSeederService;

    @Autowired
    public DatabaseSeederService(ShopSeederService shopSeederService, FactorySeederService factorySeederService, MovieSeederService movieSeederService) {
        this.shopSeederService = shopSeederService;
        this.factorySeederService = factorySeederService;
        this.movieSeederService = movieSeederService;
        this.seedDatabase();
    }

    public void seedDatabase() {
        this.shopSeederService.seedDatabase();
        this.factorySeederService.seedDatabase();
        this.movieSeederService.seedDatabase();
    }

    public void deleteAll() {
        this.shopSeederService.deleteAll();
        this.factorySeederService.deleteAll();
        this.movieSeederService.deleteAll();
    }

    public void reSeedDatabase() {
        this.deleteAll();
        this.seedDatabase();
    }
}
