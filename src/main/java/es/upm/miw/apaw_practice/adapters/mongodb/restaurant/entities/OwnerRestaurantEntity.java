package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities;

import es.upm.miw.apaw_practice.domain.models.restaurant.OwnerRestaurant;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class OwnerRestaurantEntity {
    @Id
    private String id;
    private String name;
    private String familyName;

    public OwnerRestaurantEntity(){
        //empty for framework
    }

    public OwnerRestaurantEntity(String id, String name, String familyName){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.familyName = familyName;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getFamilyName() { return familyName; }

    public void setFamilyName(String familyName) { this.familyName = familyName; }

    public OwnerRestaurant toOwnerRestaurant() {
        OwnerRestaurant ownerRestaurant = new OwnerRestaurant();
        BeanUtils.copyProperties(this, ownerRestaurant);
            return ownerRestaurant;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((OwnerRestaurantEntity) obj).id));
    }

    @Override
    public String toString() {
        return "OwnerEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                '}';
    }
}
