package es.upm.miw.apaw_practice.adapters.mongodb;

import es.upm.miw.apaw_practice.adapters.mongodb.factory.FactorySeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.padel.PadelSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.school.SchoolSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.shop.ShopSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.BankSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.movie.MovieSeederService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseSeederService {

    private ShopSeederService shopSeederService;
    private SchoolSeederService schoolSeederService;
    private FactorySeederService factorySeederService;
    private BankSeederService bankSeederService;
    private MovieSeederService movieSeederService;
    private PadelSeederService padelSeederService;
    @Autowired
    public DatabaseSeederService(ShopSeederService shopSeederService, SchoolSeederService schoolSeederService, FactorySeederService factorySeederService, BankSeederService bankSeederService, MovieSeederService movieSeederService,PadelSeederService padelSeederService) {
        this.shopSeederService = shopSeederService;
        this.schoolSeederService = schoolSeederService;
        this.factorySeederService = factorySeederService;
        this.bankSeederService = bankSeederService;
        this.movieSeederService = movieSeederService;
        this.padelSeederService = padelSeederService;
        this.seedDatabase();
    }

    public void seedDatabase() {
        this.shopSeederService.seedDatabase();
        this.schoolSeederService.seedDatabase();
        this.factorySeederService.seedDatabase();
        this.bankSeederService.seedDatabase();
        this.movieSeederService.seedDatabase();
        this.padelSeederService.seedDatabase();
    }

    public void deleteAll() {
        this.shopSeederService.deleteAll();
        this.schoolSeederService.deleteAll();
        this.factorySeederService.deleteAll();
        this.bankSeederService.deleteAll();
        this.movieSeederService.deleteAll();
        this.padelSeederService.deleteAll();
    }

    public void reSeedDatabase() {
        this.deleteAll();
        this.seedDatabase();
    }
}
