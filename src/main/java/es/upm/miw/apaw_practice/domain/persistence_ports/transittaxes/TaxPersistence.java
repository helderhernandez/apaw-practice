package es.upm.miw.apaw_practice.domain.persistence_ports.transittaxes;

import es.upm.miw.apaw_practice.domain.models.transittaxes.Tax;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxPersistence {

    Tax create(Tax tax);

    Tax findByRefTax(String refTax);

    Tax findPriceTotalTaxesByIdCar(String idCar);
}
