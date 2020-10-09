package es.upm.miw.apaw_practice.adapters.mongodb.cardealership.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class CarDealershipEntity {
    @Id
    private String id;
    private String name;
    private String address;
    private Long telephone;

    public CarDealershipEntity() {
        // Empty for framework
    }

    public CarDealershipEntity(String name, String address, Long telephone) {
        this.name = name;
        this.address = address;
        this.telephone = telephone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarDealershipEntity that = (CarDealershipEntity) o;
        return id.equals(that.id);
    }

    @Override
    public String toString() {
        return "CarDealershipEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", telephone=" + telephone +
                '}';
    }
}
