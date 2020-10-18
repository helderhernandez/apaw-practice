package es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.daos.CategorySportyRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.daos.CustomerSportyRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.daos.DiscountSportyRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.daos.ReservationSportyRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities.CategorySportyEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities.CustomerSportyEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities.DiscountSportyEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities.ReservationSportyEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.sportyRental.ReservationCreationSporty;
import es.upm.miw.apaw_practice.domain.models.sportyRental.ReservationSporty;
import es.upm.miw.apaw_practice.domain.persistence_ports.sportyRental.ReservationSportyPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository("reservationSportyPersistence")
public class ReservationSportyPersistenceMongodb implements ReservationSportyPersistence {

    private ReservationSportyRepository reservationSportyRepository;
    private CustomerSportyRepository customerSportyRepository;
    private CategorySportyRepository categorySportyRepository;
    private DiscountSportyRepository discountSportyRepository;

    @Autowired
    public ReservationSportyPersistenceMongodb(ReservationSportyRepository reservationSportyRepository, CustomerSportyRepository customerSportyRepository, CategorySportyRepository categorySportyRepository,
                                               DiscountSportyRepository discountSportyRepository) {
        this.reservationSportyRepository = reservationSportyRepository;
        this.customerSportyRepository = customerSportyRepository;
        this.categorySportyRepository = categorySportyRepository;
        this.discountSportyRepository = discountSportyRepository;
    }

    @Override
    public ReservationSporty readByRefReservation(String refReservation) {
        return this.reservationSportyRepository.findByRefReservation(refReservation)
                .orElseThrow(() -> new NotFoundException("ReservationSporty refReservation:" + refReservation)).convertToReservationSporty();
    }

    @Override
    public ReservationSporty create(ReservationCreationSporty reservationCreationSporty) {

        List<CustomerSportyEntity> listCustomers = reservationCreationSporty.getCustomersCreationSporty().stream()
                .map(customer -> this.customerSportyRepository.save(new CustomerSportyEntity(customer)))
                .collect(Collectors.toList());

        CategorySportyEntity category = new CategorySportyEntity(reservationCreationSporty.getCategoryCreationSporty());

        List<DiscountSportyEntity> listDiscounts = reservationCreationSporty.getDiscountsCreationSporty().stream()
                .map(discount -> this.discountSportyRepository.save(new DiscountSportyEntity(discount)))
                .collect(Collectors.toList());

        ReservationSportyEntity reservationEntity = new ReservationSportyEntity(reservationCreationSporty);
        reservationEntity.setCustomerSportyEntities(listCustomers);
        reservationEntity.setCategorySportyEntity(category);
        reservationEntity.setDiscountSportyEntity(listDiscounts);

        return this.reservationSportyRepository.save(reservationEntity).convertToReservationSporty();
    }
}
