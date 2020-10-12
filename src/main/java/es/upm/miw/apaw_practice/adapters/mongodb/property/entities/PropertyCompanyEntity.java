package es.upm.miw.apaw_practice.adapters.mongodb.property.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PropertyCompanyEntity {
    private String name;
    private String address;
    private String description;

    public PropertyCompanyEntity(String name, String address, String description) {
        this.name = name;
        this.address = address;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PropertyCompanyEntity{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
