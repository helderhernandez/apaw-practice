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
                FilmCategoryEntity.builder("cat1")
                        .name("Action")
                        .plus18(false)
                        .build(),
                FilmCategoryEntity.builder("cat2")
                        .name("Commedy")
                        .plus18(false)
                        .build(),
                FilmCategoryEntity.builder("cat3")
                        .name("Thriller")
                        .plus18(false)
                        .build(),
                FilmCategoryEntity.builder("cat4")
                        .name("Horror")
                        .plus18(true)
                        .build(),
                FilmCategoryEntity.builder("cat5")
                        .name("Children")
                        .plus18(false)
                        .build(),
                FilmCategoryEntity.builder("cat6")
                        .name("War")
                        .plus18(true)
                        .build()
        };
        this.filmCategoryRepository.saveAll(Arrays.asList(filmCategories));
        FilmMakerEntity[] filmMakers = {
                FilmMakerEntity.builder("filmMaker1")
                        .name("John Singleton")
                        .birthday(LocalDate.of(1970, 1, 25))
                        .gender("M")
                        .build(),
                FilmMakerEntity.builder("filmMaker2")
                        .name("William Blake Crump")
                        .birthday(LocalDate.of(1922, 2, 26))
                        .gender("M")
                        .build(),
                FilmMakerEntity.builder("filmMaker3")
                        .name("Jonathan Demme")
                        .birthday(LocalDate.of(1950, 3, 27))
                        .gender("M")
                        .build(),
                FilmMakerEntity.builder("filmMaker4")
                        .name("Steven Baker")
                        .birthday(LocalDate.of(1960, 4, 28))
                        .gender("M")
                        .build(),
                FilmMakerEntity.builder("filmMaker5")
                        .name("Kathryn Bigelow")
                        .birthday(LocalDate.of(1970, 5, 29))
                        .gender("F")
                        .build()
        };
        this.filmMakerRepository.saveAll(Arrays.asList(filmMakers));
        RentalFilmEntity[] films = {
                new RentalFilmEntity("1111", "2 Fast 2 Furious", 1998, filmMakers[0], Arrays.asList(filmCategories[0], filmCategories[2])),
                new RentalFilmEntity("2222", "The Pink Panther", 1980, filmMakers[1], Arrays.asList(filmCategories[1], filmCategories[4])),
                new RentalFilmEntity("3333", "The Silence of the Lambs", 1992, filmMakers[2], Arrays.asList(filmCategories[2])),
                new RentalFilmEntity("4444", "Generation Z", 1998, filmMakers[3], Arrays.asList(filmCategories[3])),
                new RentalFilmEntity("5555", "Zero Dark Thirty", 2012, filmMakers[4], Arrays.asList(filmCategories[2])),
                new RentalFilmEntity("6666", "The Hurt Locker", 2015, filmMakers[4], Arrays.asList(filmCategories[5])),
        };
        this.rentalFilmRepository.saveAll(Arrays.asList(films));
        CustomerAssociateEntity[] customers = {
                new CustomerAssociateEntity("DNI1", "Javier Delgado Pérez", LocalDate.of(2005, 1, 1), Arrays.asList(films[0], films[1])),
                new CustomerAssociateEntity("DNI2", "Irene Becerra Díaz", LocalDate.of(1980, 1, 1), Arrays.asList(films[2])),
                new CustomerAssociateEntity("DNI3", "Diego Hernández García", LocalDate.of(1995, 1, 1), Arrays.asList(films[3], films[4])),
                new CustomerAssociateEntity("DNI4", "Laura Jiménez González", LocalDate.of(1990, 1, 1), Arrays.asList(films[5])),
                new CustomerAssociateEntity("DNI5", "Víctor Alarcón González", LocalDate.of(2000, 1, 1), Arrays.asList()),
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

