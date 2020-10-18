package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities;

import es.upm.miw.apaw_practice.domain.models.transittaxes.Car;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.stream.Collectors;

@Document
public class CarEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String enrollment;
    private String brand;
    @DBRef
    private List<AccidentEntity> accidents;
    @DBRef
    private OwnerEntity owner;
    @DBRef
    private List<TaxEntity> taxes;

    public CarEntity() {
        //empty from framework
    }

    public CarEntity(String id, String enrollment, String brand, List<AccidentEntity> accidents,
                     OwnerEntity owner, List<TaxEntity> taxes) {
        this.id = id;
        this.enrollment = enrollment;
        this.brand = brand;
        this.accidents = accidents;
        this.owner = owner;
        this.taxes = taxes;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public String getId() {
        return id;
    }

    public List<AccidentEntity> getAccidents() {
        return accidents;
    }

    public OwnerEntity getOwner() {
        return owner;
    }

    public List<TaxEntity> getTaxes() {
        return taxes;
    }

    public Car toCar() {
        List<String> listAccidents = this.accidents.stream()
                .map(AccidentEntity::getRefAccident)
                .collect(Collectors.toList());
        List<String> listTaxes = this.taxes.stream()
                .map(TaxEntity::getRefTax)
                .collect(Collectors.toList());
        Car car = new Car();
        car.setEnrollment(this.enrollment);
        car.setRefAccidents(listAccidents);
        car.setRefTaxes(listTaxes);
        car.setBrand(this.brand);
        car.setDniOwner(this.owner.getDni());
        return car;
    }
}
