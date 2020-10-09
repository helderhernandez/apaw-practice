package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.daos.TaxRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.TaxEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.transittaxes.Tax;
import es.upm.miw.apaw_practice.domain.models.transittaxes.TaxCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.transittaxes.TaxPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("TaxPersistence")
public class TaxPersistenceMongodb implements TaxPersistence {

    private TaxRepository taxRepository;

    @Autowired
    public TaxPersistenceMongodb(TaxRepository taxRepository) {
        this.taxRepository = taxRepository;
    }

    @Override
    public Tax create(TaxCreation taxCreation) {
        assertRefTaxNoExist(taxCreation.getRefTax());
        return this.taxRepository.save(new TaxEntity(taxCreation)).toTax();
    }

    private void assertRefTaxNoExist(String refTax) {
        this.taxRepository.findByRefTax(refTax)
                .ifPresent(taxEntity -> {
                    throw new ConflictException("RefTax exist: " + refTax);
                });
    }

    @Override
    public Tax findByRefTax(String refTax) {
        return this.taxRepository
                .findByRefTax(refTax)
                .orElseThrow(() -> new NotFoundException("Tax refTax: " + refTax))
                .toTax();
    }
}
