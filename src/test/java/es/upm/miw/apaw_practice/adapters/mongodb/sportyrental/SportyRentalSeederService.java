package es.upm.miw.apaw_practice.adapters.mongodb.sportyrental;


import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.daos.CategorySportyRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.daos.CustomerSportyRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.daos.DiscountSportyRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.daos.ReservationSportyRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities.CategorySportyEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities.CustomerSportyEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities.DiscountSportyEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities.ReservationSportyEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SportyRentalSeederService {

    @Autowired
    private CustomerSportyRepository customerSportyRepository;
    @Autowired
    private ReservationSportyRepository reservationSportyRepository;
    @Autowired
    private CategorySportyRepository categorySportyRepository;
    @Autowired
    private DiscountSportyRepository discountSportyRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Sporty Rental Inital Load -----------");

        CustomerSportyEntity[] customerSportEntities = {
                new CustomerSportyEntity("1", "50309080J", "Pedro", "Pascual Sanchez", "pedro.pascual@gmail.com", "777888999"),
                new CustomerSportyEntity("2", "50407080J", "Ana", "Lopez Garcia", "ana.lopez@gmail.com", "666888999"),
                new CustomerSportyEntity("3", "50506080J", "Enrique", "Lopez Sebastian", "enrique.lopez@gmail.com", "666777999"),
                new CustomerSportyEntity("4", "50206090J", "Marta", "Alonso Garcia", "marta.garcia@gmail.com", "666444999")
        };

        customerSportyRepository.saveAll(List.of(customerSportEntities));


        CategorySportyEntity[] categorySportyEntities = {
                new CategorySportyEntity("1", "Football 7", 7),
                new CategorySportyEntity("2", "Paddle", 4),
                new CategorySportyEntity("3", "Tennis", 2),
                new CategorySportyEntity("4", "Basket", 10)
        };

        categorySportyRepository.saveAll(List.of(categorySportyEntities));

        DiscountSportyEntity[] discountSportyEntities = {
                new DiscountSportyEntity("1", "Large Family", 15.0),
                new DiscountSportyEntity("2", "Card Youth", 10.0),
                new DiscountSportyEntity("3", "Impairment", 40.0)
        };

        discountSportyRepository.saveAll(List.of(discountSportyEntities));

        ReservationSportyEntity[] reservationSportEntities = {
                new ReservationSportyEntity("1", LocalDateTime.of(2020, 11, 10, 0, 0), "R3458901", new BigDecimal(15), Boolean.TRUE, List.of(customerSportEntities[0], customerSportEntities[1], customerSportEntities[2]), categorySportyEntities[0],
                        List.of(discountSportyEntities[0], discountSportyEntities[1])),
                new ReservationSportyEntity("2", LocalDateTime.of(2020, 11, 11, 0, 0), "R3458902", new BigDecimal(20), Boolean.FALSE, List.of(customerSportEntities[2], customerSportEntities[3]), categorySportyEntities[1],
                        List.of(discountSportyEntities[2])),
                new ReservationSportyEntity("3", LocalDateTime.of(2020, 11, 17, 0, 0), "R3458903", new BigDecimal(20), Boolean.TRUE, List.of(customerSportEntities[2], customerSportEntities[3]), categorySportyEntities[2],
                        List.of(discountSportyEntities[2])),
                new ReservationSportyEntity("4", LocalDateTime.of(2020, 11, 25, 0, 0), "R3458904", new BigDecimal(15), Boolean.FALSE, List.of(customerSportEntities[0], customerSportEntities[2], customerSportEntities[3]), categorySportyEntities[3],
                        List.of(discountSportyEntities[0], discountSportyEntities[2]))
        };

        reservationSportyRepository.saveAll(List.of(reservationSportEntities));


    }

    public void deleteAll() {
        categorySportyRepository.deleteAll();
        discountSportyRepository.deleteAll();
        customerSportyRepository.deleteAll();
        reservationSportyRepository.deleteAll();
    }
}
