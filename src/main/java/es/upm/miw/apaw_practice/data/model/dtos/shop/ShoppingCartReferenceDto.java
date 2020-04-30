package es.upm.miw.apaw_practice.data.model.dtos.shop;

import es.upm.miw.apaw_practice.data.model.entities.shop.ShoppingCart;

public class ShoppingCartReferenceDto {

    private String id;
    private String user;

    public ShoppingCartReferenceDto() {
        //empty for framework
    }

    public ShoppingCartReferenceDto(ShoppingCart shoppingCart) {
        this.id = shoppingCart.getId();
        this.user = shoppingCart.getUser();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ShoppingCartReferenceDto{" +
                "id='" + id + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
