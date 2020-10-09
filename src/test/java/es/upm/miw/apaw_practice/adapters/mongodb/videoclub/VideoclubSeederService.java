package es.upm.miw.apaw_practice.adapters.mongodb.videoclub;

import es.upm.miw.apaw_practice.adapters.mongodb.videoclub.daos.CustomerAssociateRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.videoclub.daos.FilmCategoryRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.videoclub.daos.FilmMakerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.videoclub.daos.RentalFilmRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.videoclub.entities.CustomerAssociateEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.videoclub.entities.FilmCategoryEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.videoclub.entities.FilmMakerEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.videoclub.entities.RentalFilmEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;

@Service
public class VideoclubSeederService {

    @Autowired
    private CustomerAssociateRepository customerAssociateRepository;
    @Autowired
    private FilmCategoryRepository filmCategoryRepository;
    @Autowired
    private FilmMakerRepository filmMakerRepository;
    @Autowired
    private RentalFilmRepository rentalFilmRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Videoclub Initial Load -----------");
        FilmCategoryEntity[] filmCategories = {
                new FilmCategoryEntity("cat1", "Action", "Races", false),
                new FilmCategoryEntity("cat2", "Commedy", "Family", false),
                new FilmCategoryEntity("cat3", "Thriller", "Police", false),
                new FilmCategoryEntity("cat4", "Horror", "Zombies", true),
                new FilmCategoryEntity("cat5", "Children", "Family", false),
                new FilmCategoryEntity("cat6", "War", "EEUU", true)
        };
        this.filmCategoryRepository.saveAll(Arrays.asList(filmCategories));
        FilmMakerEntity[] filmMakers = {
                new FilmMakerEntity("filmMaker1", "John", "Singleton", LocalDate.of(1970, 1, 25), "M"),
                new FilmMakerEntity("filmMaker2", "William", "Blake Crump", LocalDate.of(1922, 2, 26), "M"),
                new FilmMakerEntity("filmMaker3", "Jonathan", "Demme", LocalDate.of(1950, 3, 27), "M"),
                new FilmMakerEntity("filmMaker4", "Steven", "Baker", LocalDate.of(1960, 4, 28), "M"),
                new FilmMakerEntity("filmMaker5", "Kathryn", "Bigelow", LocalDate.of(1970, 5, 29), "F")
        };
        this.filmMakerRepository.saveAll(Arrays.asList(filmMakers));
        RentalFilmEntity[] films = {
                new RentalFilmEntity("1111", "2 Fast 2 Furious", "description1", 1998, 130, filmMakers[0], Arrays.asList(filmCategories[0], filmCategories[2])),
                new RentalFilmEntity("2222", "The Pink Panther", "description2", 1980, 140, filmMakers[1], Arrays.asList(filmCategories[1], filmCategories[4])),
                new RentalFilmEntity("3333", "The Silence of the Lambs", "description3", 1992, 150, filmMakers[2], Arrays.asList(filmCategories[2])),
                new RentalFilmEntity("4444", "Generation Z", "description4", 1998, 140, filmMakers[3], Arrays.asList(filmCategories[3])),
                new RentalFilmEntity("5555", "Zero Dark Thirty", "description5", 2012, 150, filmMakers[4], Arrays.asList(filmCategories[2])),
                new RentalFilmEntity("6666", "The Hurt Locker", "description6", 2015, 120, filmMakers[4], Arrays.asList(filmCategories[5])),
        };
        this.rentalFilmRepository.saveAll(Arrays.asList(films));
        CustomerAssociateEntity[] customers = {
                new CustomerAssociateEntity("DNI1", "Javier", "Delgado Pérez", LocalDate.of(2005, 1, 1), "tel1", Arrays.asList(films[0], films[1])),
                new CustomerAssociateEntity("DNI2", "Irene", "Becerra Díaz", LocalDate.of(1980, 1, 1), "tel2", Arrays.asList(films[2])),
                new CustomerAssociateEntity("DNI3", "Diego", "Hernández García", LocalDate.of(1995, 1, 1), "tel3", Arrays.asList(films[3], films[4])),
                new CustomerAssociateEntity("DNI4", "Laura", "Jiménez González", LocalDate.of(1990, 1, 1), "tel4", Arrays.asList(films[5])),
                new CustomerAssociateEntity("DNI5", "Víctor", "Alarcón González", LocalDate.of(2000, 1, 1), "tel5", null),
        };
        this.customerAssociateRepository.saveAll(Arrays.asList(customers));
    }

    public void deleteAll() {
        this.customerAssociateRepository.deleteAll();
        this.rentalFilmRepository.deleteAll();
        this.filmMakerRepository.deleteAll();
        this.filmCategoryRepository.deleteAll();
    }
}

