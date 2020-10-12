package es.upm.miw.apaw_practice.adapters.mongodb.property.entities;

import es.upm.miw.apaw_practice.domain.models.property.PropertyStaff;
import es.upm.miw.apaw_practice.domain.models.property.PropertyStaffCreation;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document
public class PropertyStaffEntity {
    @Id
    private String id;
    private String name;
    private String dni;
    private String description;

    public PropertyStaffEntity(String id, String name, String dni, String description) {
        this.id = id;
        this.name = name;
        this.dni = dni;
        this.description = description;
    }

    public PropertyStaffEntity(PropertyStaffCreation propertyStaffCreation) {
        BeanUtils.copyProperties(propertyStaffCreation, this);
        this.id = UUID.randomUUID().toString();
    }

    public PropertyStaff toPropertyStaff() {
        PropertyStaff propertyStaff = new PropertyStaff();
        BeanUtils.copyProperties(this,propertyStaff);
        return propertyStaff;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertyStaffEntity that = (PropertyStaffEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "PropertyStaffEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dni='" + dni + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
