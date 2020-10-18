package es.upm.miw.apaw_practice.adapters.rest.restaurant;

import es.upm.miw.apaw_practice.domain.models.restaurant.OwnerRestaurant;

public class NameDto {
    private String name;

    public NameDto() {
        //Empty for framework
    }

    NameDto(OwnerRestaurant ownerRestaurant) {
        this.name = ownerRestaurant.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NameDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
