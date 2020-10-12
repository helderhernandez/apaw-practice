package es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.daos.DiscountSportyRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.entities.DiscountSportyEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.sportyRental.DiscountSporty;
import es.upm.miw.apaw_practice.domain.persistence_ports.sportyRental.DiscountSportyPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("discountSportyPersistence")
public class DiscountSportyPersistenceMongodb implements DiscountSportyPersistence {


    private DiscountSportyRepository discountSportyRepository;

    @Autowired
    public DiscountSportyPersistenceMongodb(DiscountSportyRepository discountSportyRepository) {
        this.discountSportyRepository = discountSportyRepository;
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
}
