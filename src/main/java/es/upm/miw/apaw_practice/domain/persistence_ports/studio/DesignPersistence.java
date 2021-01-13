package es.upm.miw.apaw_practice.domain.persistence_ports.studio;

import es.upm.miw.apaw_practice.domain.models.studio.Design;
import es.upm.miw.apaw_practice.domain.models.studio.DesignCreation;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignPersistence {

    Design create(DesignCreation designCreation);
}
