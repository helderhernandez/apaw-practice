package es.upm.miw.apaw_practice.domain.models.library;

import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.OrderEntity;

import java.util.List;
import java.util.Objects;

public class Librarian {
    private String id;
    private String name;
    private String phone;
    private List<OrderEntity> orderEntities;

    public Librarian(){
        //empty from framework
    }

    public Librarian(String id, String name, String phone, List<OrderEntity> orderEntities) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.orderEntities = orderEntities;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<OrderEntity> getOrderEntities() {
        return orderEntities;
    }

    public void setOrderEntities(List<OrderEntity> orderEntities) {
        this.orderEntities = orderEntities;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", orderEntities=" + orderEntities +
                '}';
    }
}
