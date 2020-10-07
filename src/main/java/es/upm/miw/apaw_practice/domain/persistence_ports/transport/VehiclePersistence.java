package es.upm.miw.apaw_practice.domain.persistence_ports.transport;

import es.upm.miw.apaw_practice.domain.models.shop.Article;
import es.upm.miw.apaw_practice.domain.models.shop.ArticleCreation;
import es.upm.miw.apaw_practice.domain.models.transport.Vehicle;
import es.upm.miw.apaw_practice.domain.models.transport.Worker;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiclePersistence {

    Vehicle create(Vehicle vehicle);

}
