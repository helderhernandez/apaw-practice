package es.upm.miw.apaw_practice.adapters.mongodb;

import es.upm.miw.apaw_practice.adapters.mongodb.factory.FactorySeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.HospitalSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.KitchenSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.padel.PadelSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.project.ProjectSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.school.SchoolSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.shop.ShopSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.BankSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.movie.MovieSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.SportCentreSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.VeterinarySeederService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseSeederService {

    private ShopSeederService shopSeederService;
    private SchoolSeederService schoolSeederService;
    private FactorySeederService factorySeederService;
    private KitchenSeederService kitchenSeederService;
    private BankSeederService bankSeederService;
    private MovieSeederService movieSeederService;
    private PadelSeederService padelSeederService;
    private SportCentreSeederService sportCentreSeederService;
    private ProjectSeederService projectSeederService;
    private HospitalSeederService hospitalSeederService;
    private VeterinarySeederService veterinarySeederService;

    @Autowired
    public DatabaseSeederService(ShopSeederService shopSeederService, SchoolSeederService schoolSeederService,
                                 FactorySeederService factorySeederService, BankSeederService bankSeederService,
                                 MovieSeederService movieSeederService, PadelSeederService padelSeederService,
                                 SportCentreSeederService sportCentreSeederService, KitchenSeederService kitchenSeederService,
                                 ProjectSeederService projectSeederService, HospitalSeederService hospitalSeederService,
                                 VeterinarySeederService veterinarySeederService) {
        this.shopSeederService = shopSeederService;
        this.schoolSeederService = schoolSeederService;
        this.factorySeederService = factorySeederService;
        this.kitchenSeederService = kitchenSeederService;
        this.bankSeederService = bankSeederService;
        this.movieSeederService = movieSeederService;
        this.padelSeederService = padelSeederService;
        this.sportCentreSeederService = sportCentreSeederService;
        this.projectSeederService = projectSeederService;
        this.hospitalSeederService = hospitalSeederService;
        this.veterinarySeederService = veterinarySeederService;
        this.seedDatabase();
    }

    public void seedDatabase() {
        this.shopSeederService.seedDatabase();
        this.schoolSeederService.seedDatabase();
        this.factorySeederService.seedDatabase();
        this.kitchenSeederService.seedDatabase();
        this.bankSeederService.seedDatabase();
        this.movieSeederService.seedDatabase();
        this.padelSeederService.seedDatabase();
        this.sportCentreSeederService.seedDatabase();
        this.projectSeederService.seedDatabase();
        this.hospitalSeederService.seedDatabase();
        this.veterinarySeederService.seedDatabase();
    }

    public void deleteAll() {
        this.shopSeederService.deleteAll();
        this.schoolSeederService.deleteAll();
        this.factorySeederService.deleteAll();
        this.kitchenSeederService.deleteAll();
        this.bankSeederService.deleteAll();
        this.movieSeederService.deleteAll();
        this.padelSeederService.deleteAll();
        this.sportCentreSeederService.deleteAll();
        this.projectSeederService.deleteAll();
        this.hospitalSeederService.deleteAll();
        this.veterinarySeederService.deleteAll();
    }

    public void reSeedDatabase() {
        this.deleteAll();
        this.seedDatabase();
    }
}
