package es.upm.miw.apaw_practice.data_adapter.shop;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
public class ShoppingCart {
    @Id
    private String id;
    private LocalDateTime creationDate;
    private List<Item> items;
    private String user;
    private String address;

    public ShoppingCart() {
        this.creationDate = LocalDateTime.now();
    }

    public ShoppingCart(String id, List<Item> items, String user, String address) {
        this();
        this.id = id;
        this.items = items;
        this.user = user;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((ShoppingCart) obj).id));
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id='" + id + '\'' +
                ", creationDate=" + creationDate +
                ", items=" + items +
                ", user='" + user + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
