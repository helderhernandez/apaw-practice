package es.upm.miw.apaw_practice.adapters.mongodb.property.entities;

import es.upm.miw.apaw_practice.domain.models.property.PropertyCompany;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PropertyCompanyEntity {

    @DBRef
    private PropertyStaffEntity propertyStaffEntity;

    private String name;
    private String address;
    private String description;

    public PropertyCompanyEntity(){
        //empty from framework
    }
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

    public PropertyCompany toPropertyCompany() {
        PropertyCompany propertyCompany = new PropertyCompany();
        BeanUtils.copyProperties(this, propertyCompany);
        return propertyCompany;
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
