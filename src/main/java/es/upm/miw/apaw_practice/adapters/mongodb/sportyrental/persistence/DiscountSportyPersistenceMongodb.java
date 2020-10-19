package es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.daos.DiscountSportyRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.daos.ReservationSportyRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities.DiscountSportyEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities.ReservationSportyEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.sportyrental.DiscountSporty;
import es.upm.miw.apaw_practice.domain.persistence_ports.sportyrental.DiscountSportyPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.stream.Stream;

@Repository("discountSportyPersistence")
public class DiscountSportyPersistenceMongodb implements DiscountSportyPersistence {


    private DiscountSportyRepository discountSportyRepository;
    private ReservationSportyRepository reservationSportyRepository;

    @Autowired
    public DiscountSportyPersistenceMongodb(DiscountSportyRepository discountSportyRepository, ReservationSportyRepository reservationSportyRepository) {
        this.discountSportyRepository = discountSportyRepository;
        this.reservationSportyRepository = reservationSportyRepository;
    }

    @Override
    public Stream<DiscountSporty> readAll() {
        return this.discountSportyRepository.findAll().stream().map(DiscountSportyEntity::convertToDiscountSporty);
    }

    @Override
    public DiscountSporty updateDescription(String idDiscountSporty, Double percentage) {
        DiscountSportyEntity discountSportyEntity = this.discountSportyRepository.findById(idDiscountSporty)
                .orElseThrow(() -> new NotFoundException("DiscountSporty id: " + idDiscountSporty));
        discountSportyEntity.setPercentage(percentage);

        return this.discountSportyRepository.save(discountSportyEntity).convertToDiscountSporty();
    }

    @Override
    public Stream<String> readDescriptionsDiscountByNumMaxPersonGreaterThan(Integer numMaxPerson) {
        return this.reservationSportyRepository.findAll().stream().filter(reservationSportyEntity -> reservationSportyEntity.getCategorySportyEntity() != null
                && reservationSportyEntity.getCategorySportyEntity().getNumMaxPersons() > numMaxPerson).map(ReservationSportyEntity::getDiscountSportyEntity).
                flatMap(Collection::stream).map(DiscountSportyEntity::getDescription).distinct().sorted();
    }
}
