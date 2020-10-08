package es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory;


import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.daos.FurnitureRepository;

import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities.FurnitureEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

@Service
public class FurnitureFactorySeederService {

    @Autowired
    private FurnitureRepository furnitureRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- FurnitureFactory Initial Load -----------");

        FurnitureEntity[] furniture = {
                new FurnitureEntity("Desk", new BigDecimal("15.90"), LocalDate.of(2021, 11, 13), 10000L),
                new FurnitureEntity("Bed", new BigDecimal("89.90"), LocalDate.of(2020, 6, 1),11000L),
                new FurnitureEntity("Chair", new BigDecimal("35.60"), LocalDate.of(2020, 5, 23), 13000L),
                new FurnitureEntity("Chest", new BigDecimal("79.90"), LocalDate.of(2020, 4, 2), 14000L),

        };
        this.furnitureRepository.saveAll(Arrays.asList(furniture));
    }

    public void deleteAll() {
        this.furnitureRepository.deleteAll();

    }
}


