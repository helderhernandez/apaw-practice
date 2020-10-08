package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities;

import es.upm.miw.apaw_practice.domain.models.transittaxes.Car;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

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
    private List<TransitTaxesEntity> transitTaxes;

    public CarEntity() {
        //empty from framework
    }

    public CarEntity(String id, String enrollment, String brand, List<AccidentEntity> accidents,
                     OwnerEntity owner, List<TransitTaxesEntity> transitTaxes) {
        this.id = id;
        this.enrollment = enrollment;
        this.brand = brand;
        this.accidents = accidents;
        this.owner = owner;
        this.transitTaxes = transitTaxes;
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

    public List<TransitTaxesEntity> getTransitTaxes() {
        return transitTaxes;
    }

    public void setTransitTaxes(List<TransitTaxesEntity> transitTaxes) {
        this.transitTaxes = transitTaxes;
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
                Objects.equals(transitTaxes, that.transitTaxes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, enrollment, brand, accidents, owner, transitTaxes);
    }

    @Override
    public String toString() {
        return "CarEntity{" +
                "id='" + id + '\'' +
                ", enrollment='" + enrollment + '\'' +
                ", brand='" + brand + '\'' +
                ", accidents=" + accidents +
                ", owner=" + owner +
                ", transitTaxes=" + transitTaxes +
                '}';
    }

    public Car toCar() {
        Car car = new Car();
        BeanUtils.copyProperties(this, car);
        return car;
    }
}
