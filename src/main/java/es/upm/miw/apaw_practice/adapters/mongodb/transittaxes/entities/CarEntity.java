package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities;

import es.upm.miw.apaw_practice.domain.models.transittaxes.Car;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;
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
                     OwnerEntity owner, List<TaxEntity> transitTaxes) {
        this.id = id;
        this.enrollment = enrollment;
        this.brand = brand;
        this.accidents = accidents;
        this.owner = owner;
        this.taxes = transitTaxes;
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

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<AccidentEntity> getAccidents() {
        return accidents;
    }

    public void setAccidents(List<AccidentEntity> accidents) {
        this.accidents = accidents;
    }

    public OwnerEntity getOwner() {
        return owner;
    }

    public void setOwner(OwnerEntity owner) {
        this.owner = owner;
    }

    public List<TaxEntity> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<TaxEntity> taxes) {
        this.taxes = taxes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarEntity that = (CarEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(enrollment, that.enrollment) &&
                Objects.equals(brand, that.brand) &&
                Objects.equals(accidents, that.accidents) &&
                Objects.equals(owner, that.owner) &&
                Objects.equals(taxes, that.taxes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, enrollment, brand, accidents, owner, taxes);
    }

    @Override
    public String toString() {
        return "CarEntity{" +
                "id='" + id + '\'' +
                ", enrollment='" + enrollment + '\'' +
                ", brand='" + brand + '\'' +
                ", accidents=" + accidents +
                ", owner=" + owner +
                ", transitTaxes=" + taxes +
                '}';
    }

    public Car toCar() {
        List<String> accidents = this.accidents.stream()
                .map(AccidentEntity::getRefAccident)
                .collect(Collectors.toList());
        List<String> taxes = this.taxes.stream()
                .map(TaxEntity::getRefTax)
                .collect(Collectors.toList());
        Car car = new Car();
        car.setEnrollment(this.enrollment);
        car.setRefAccidents(accidents);
        car.setRefTaxes(taxes);
        car.setBrand(this.brand);
        car.setDniOwner(this.owner.getDni());
        return car;
    }
}
