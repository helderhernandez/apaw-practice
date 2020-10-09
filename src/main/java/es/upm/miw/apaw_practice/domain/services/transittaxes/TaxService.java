package es.upm.miw.apaw_practice.domain.services.transittaxes;

import es.upm.miw.apaw_practice.domain.models.transittaxes.Tax;
import es.upm.miw.apaw_practice.domain.models.transittaxes.TaxCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.transittaxes.TaxPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxService {

    private TaxPersistence taxPersistence;

    @Autowired
    public TaxService(TaxPersistence taxPersistence) {
        this.taxPersistence = taxPersistence;
    }

    public Tax create(TaxCreation taxCreation) {
        return taxPersistence.create(taxCreation);
    }
}
