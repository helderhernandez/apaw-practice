package es.upm.miw.apaw_practice.domain.persistence_ports.transittaxes;

import es.upm.miw.apaw_practice.domain.models.transittaxes.Tax;
import es.upm.miw.apaw_practice.domain.models.transittaxes.TaxCreation;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxPersistence {
    Tax create(TaxCreation taxCreation);
    Tax findByRefTax (String refTax);
}
