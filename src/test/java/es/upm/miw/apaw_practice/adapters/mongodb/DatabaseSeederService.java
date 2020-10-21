package es.upm.miw.apaw_practice.adapters.mongodb;

import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.FurnitureFactorySeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.AdCampaignSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.Property.PropertySeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.article.ArticleSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.AirportSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.BankSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.BasketballSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.CarDealershipSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.exercise.persistence.ExerciseSeedService;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.FactorySeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.FilmForumSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.garage.GarageSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.HospitalSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.KitchenSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.library.LibrarySeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.movie.MovieSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.music.MusicSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.padel.PadelSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.project.ProjectSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.race.RaceSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.school.SchoolSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.shop.ShopSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.SocialNetworkSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.SportCentreSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.SportyRentalSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.TicketBusSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.transport.TransportSeedService;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.TransitTaxesSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.TreeConservationSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.VeterinarySeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.videoclub.VideoclubSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame.VideogameSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.RestaurantSeederService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseSeederService {

    private ShopSeederService shopSeederService;
    private SchoolSeederService schoolSeederService;
    private FactorySeederService factorySeederService;
    private KitchenSeederService kitchenSeederService;
    private ArticleSeederService articleSeederService;
    private BankSeederService bankSeederService;
    private MovieSeederService movieSeederService;
    private PadelSeederService padelSeederService;
    private SportCentreSeederService sportCentreSeederService;
    private ProjectSeederService projectSeederService;
    private HospitalSeederService hospitalSeederService;
    private VeterinarySeederService veterinarySeederService;
    private GarageSeederService garageSeederService;
    private AirportSeederService airportSeederService;
    private TicketBusSeederService ticketBusSeederService;
    private TransportSeedService transportSeedService;
    private VideogameSeederService videogameSeederService;
    private TransitTaxesSeederService transitTaxesSeederService;
    private SocialNetworkSeederService socialNetworkSeederService;
    private AdCampaignSeederService adCampaignSeederService;
    private FilmForumSeederService filmForumSeederService;
    private PropertySeederService propertySeederService;
    private RestaurantSeederService restaurantSeederService;
    private FurnitureFactorySeederService furnitureFactorySeederService;
    private LibrarySeederService librarySeederService;
    private VideoclubSeederService videoclubSeederService;
    private BasketballSeederService basketballSeederService;
    private CarDealershipSeederService carDealershipSeederService;
    private RaceSeederService raceSeederService;
    private MusicSeederService musicSeederService;
    private ExerciseSeedService exerciseSeedService;
    private SportyRentalSeederService sportyRentalSeederService;
    private TreeConservationSeederService treeConservationSeederService;

    @Autowired
    public DatabaseSeederService(ShopSeederService shopSeederService, SchoolSeederService schoolSeederService,
                                 FactorySeederService factorySeederService, BankSeederService bankSeederService,
                                 MovieSeederService movieSeederService, PadelSeederService padelSeederService,
                                 SportCentreSeederService sportCentreSeederService, KitchenSeederService kitchenSeederService, ArticleSeederService articleSeederService,
                                 ProjectSeederService projectSeederService, HospitalSeederService hospitalSeederService,
                                 VeterinarySeederService veterinarySeederService, GarageSeederService garageSeederService,
                                 AirportSeederService airportSeederService, TicketBusSeederService ticketBusSeederService,
                                 VideogameSeederService videogameSeederService, TransitTaxesSeederService transitTaxesSeederService,
                                 TransportSeedService transportSeedService, SocialNetworkSeederService socialNetworkSeederService,
                                 RestaurantSeederService restaurantSeederService, FilmForumSeederService filmForumSeederService,
                                 AdCampaignSeederService adCampaignSeederService,
                                 PropertySeederService propertySeederService,FurnitureFactorySeederService furnitureFactorySeederService,
                                 LibrarySeederService librarySeederService, VideoclubSeederService videoclubSeederService,
                                 BasketballSeederService basketballSeederService, CarDealershipSeederService carDealershipSeederService, RaceSeederService raceSeederService,
                                 MusicSeederService musicSeederService,ExerciseSeedService exerciseSeedService, SportyRentalSeederService sportyRentalSeederService,
                                 TreeConservationSeederService treeConservationSeederService) {


        this.shopSeederService = shopSeederService;
        this.schoolSeederService = schoolSeederService;
        this.factorySeederService = factorySeederService;
        this.kitchenSeederService = kitchenSeederService;
        this.articleSeederService = articleSeederService;
        this.bankSeederService = bankSeederService;
        this.movieSeederService = movieSeederService;
        this.padelSeederService = padelSeederService;
        this.sportCentreSeederService = sportCentreSeederService;
        this.projectSeederService = projectSeederService;
        this.hospitalSeederService = hospitalSeederService;
        this.veterinarySeederService = veterinarySeederService;
        this.garageSeederService = garageSeederService;
        this.airportSeederService = airportSeederService;
        this.ticketBusSeederService = ticketBusSeederService;
        this.transportSeedService = transportSeedService;
        this.videogameSeederService = videogameSeederService;
        this.transitTaxesSeederService = transitTaxesSeederService;
        this.socialNetworkSeederService = socialNetworkSeederService;
        this.restaurantSeederService = restaurantSeederService;
        this.adCampaignSeederService = adCampaignSeederService;
        this.filmForumSeederService = filmForumSeederService;
        this.propertySeederService = propertySeederService;
        this.furnitureFactorySeederService=furnitureFactorySeederService;
        this.librarySeederService=librarySeederService;
        this.videoclubSeederService = videoclubSeederService;
        this.basketballSeederService = basketballSeederService;
        this.raceSeederService = raceSeederService;
        this.carDealershipSeederService = carDealershipSeederService;
        this.musicSeederService = musicSeederService;
        this.exerciseSeedService = exerciseSeedService;
        this.sportyRentalSeederService = sportyRentalSeederService;
        this.treeConservationSeederService = treeConservationSeederService;
        this.seedDatabase();
    }

    public void seedDatabase() {
        this.shopSeederService.seedDatabase();
        this.schoolSeederService.seedDatabase();
        this.factorySeederService.seedDatabase();
        this.kitchenSeederService.seedDatabase();
        this.articleSeederService.seedDatabase();
        this.bankSeederService.seedDatabase();
        this.movieSeederService.seedDatabase();
        this.padelSeederService.seedDatabase();
        this.sportCentreSeederService.seedDatabase();
        this.projectSeederService.seedDatabase();
        this.hospitalSeederService.seedDatabase();
        this.veterinarySeederService.seedDatabase();
        this.garageSeederService.seedDatabase();
        this.airportSeederService.seedDataBase();
        this.ticketBusSeederService.seedDatabase();
        this.transportSeedService.seedDatabase();
        this.videogameSeederService.seedDataBase();
        this.transitTaxesSeederService.seedDatabase();
        this.socialNetworkSeederService.seedDatabase();
        this.restaurantSeederService.seedDatabase();
        this.adCampaignSeederService.seedDatabase();
        this.filmForumSeederService.seedDatabase();
        this.propertySeederService.seedDatabase();
        this.furnitureFactorySeederService.seedDatabase();
        this.librarySeederService.seedDatabase();
        this.videoclubSeederService.seedDatabase();
        this.basketballSeederService.seedDatabase();
        this.raceSeederService.seedDatabase();
        this.carDealershipSeederService.seedDatabase();
        this.musicSeederService.seedDatabase();
        this.exerciseSeedService.seedDatabase();
        this.sportyRentalSeederService.seedDatabase();
        this.treeConservationSeederService.seedDatabase();
    }

    public void deleteAll() {
        this.shopSeederService.deleteAll();
        this.schoolSeederService.deleteAll();
        this.factorySeederService.deleteAll();
        this.kitchenSeederService.deleteAll();
        this.articleSeederService.deleteAll();
        this.bankSeederService.deleteAll();
        this.movieSeederService.deleteAll();
        this.padelSeederService.deleteAll();
        this.sportCentreSeederService.deleteAll();
        this.projectSeederService.deleteAll();
        this.hospitalSeederService.deleteAll();
        this.veterinarySeederService.deleteAll();
        this.garageSeederService.deleteAll();
        this.airportSeederService.deleteAll();
        this.ticketBusSeederService.deleteAll();
        this.transportSeedService.deleteAll();
        this.videogameSeederService.deleteAll();
        this.transitTaxesSeederService.deleteAll();
        this.socialNetworkSeederService.deleteAll();
        this.restaurantSeederService.deleteAll();
        this.adCampaignSeederService.deleteAll();
        this.filmForumSeederService.deleteAll();
        this.propertySeederService.deleteAll();
        this.furnitureFactorySeederService.deleteAll();
        this.librarySeederService.deleteAll();
        this.videoclubSeederService.deleteAll();
        this.basketballSeederService.deleteAll();
        this.carDealershipSeederService.deleteAll();
        this.raceSeederService.deleteAll();
        this.musicSeederService.deleteAll();
        this.exerciseSeedService.deleteAll();
        this.sportyRentalSeederService.deleteAll();
        this.treeConservationSeederService.deleteAll();
    }

    public void reSeedDatabase() {
        this.deleteAll();
        this.seedDatabase();
    }
}
