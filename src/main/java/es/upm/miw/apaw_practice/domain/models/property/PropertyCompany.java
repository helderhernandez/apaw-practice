package es.upm.miw.apaw_practice.domain.models.property;

import es.upm.miw.apaw_practice.adapters.mongodb.property.entities.PropertyStaffEntity;

public class PropertyCompany {

    private PropertyStaffEntity propertyStaffEntity;

    private String name;
    private String address;
    private String description;

    public PropertyCompany(){
        //empty from framework
    }

    public PropertyCompany(String name) {
        this.name = name;
    }

    public PropertyStaffEntity getPropertyStaffEntity() {
        return propertyStaffEntity;
    }

    public void setPropertyStaffEntity(PropertyStaffEntity propertyStaffEntity) {
        this.propertyStaffEntity = propertyStaffEntity;
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
        return "PropertyCompany{" +
                "propertyStaffEntity=" + propertyStaffEntity +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
