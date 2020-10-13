package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.daos.CarRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.daos.TaxRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.CarEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.TaxEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.transittaxes.Tax;
import es.upm.miw.apaw_practice.domain.persistence_ports.transittaxes.TaxPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.stream.Stream;

@Repository("TaxPersistence")
public class TaxPersistenceMongodb implements TaxPersistence {

    private TaxRepository taxRepository;
    private CarRepository carRepository;

    @Autowired
    public TaxPersistenceMongodb(TaxRepository taxRepository, CarRepository carRepository) {
        this.taxRepository = taxRepository;
        this.carRepository = carRepository;
    }

    @Override
    public Tax create(Tax tax) {
        assertRefTaxNoExist(tax.getRefTax());
        return this.taxRepository.save(new TaxEntity(tax)).toTax();
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

    @Override
    public Tax findPriceTotalTaxesByIdCar(String idCar) {
        BigDecimal total = findTaxesByIdCar(idCar)
                .map(Tax::getPrice)
                .reduce(BigDecimal::add)
                .orElse(new BigDecimal("0.00"));
        Tax taxTotal = new Tax();
        taxTotal.setPrice(total);
        return taxTotal;
    }

    public Stream<Tax> findTaxesByIdCar(String idCar) {
        CarEntity carEntity = this.carRepository.findById(idCar)
                .orElseThrow(() -> new NotFoundException("Car id: " + idCar));
        return carEntity.getTaxes().stream()
                .map(TaxEntity::toTax);
    }
}
