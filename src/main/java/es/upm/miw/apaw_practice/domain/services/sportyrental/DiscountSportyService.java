package es.upm.miw.apaw_practice.domain.services.sportyrental;

import es.upm.miw.apaw_practice.domain.models.sportyrental.DiscountSporty;
import es.upm.miw.apaw_practice.domain.persistence_ports.sportyrental.DiscountSportyPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class DiscountSportyService {

    private DiscountSportyPersistence discountSportyPersistence;

    @Autowired
    public DiscountSportyService(DiscountSportyPersistence discountSportyPersistence) {
        this.discountSportyPersistence = discountSportyPersistence;
    }

    public DiscountSporty updateDescription(String idDiscountSporty, Double percentage) {
        return this.discountSportyPersistence.updateDescription(idDiscountSporty, percentage);
    }

    public Stream<String> readDescriptionsDiscountByNumMaxPersonGreaterThan(Integer numMaxPerson) {
        return this.discountSportyPersistence.readDescriptionsDiscountByNumMaxPersonGreaterThan(numMaxPerson);
    }
}
